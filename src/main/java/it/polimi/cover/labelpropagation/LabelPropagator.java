package it.polimi.cover.labelpropagation;

import java.util.HashMap;
import java.util.Map;

import it.polimi.checker.SatisfactionValue;
import it.polimi.cover.models.goal.GOALMODEL;
import it.polimi.cover.utils.SatisfactionValueAdapter;

public class LabelPropagator {

	private GOALMODEL goalModel;
	private GOALMODEL.SCENARIO goalModelScenario;

	private Map<Integer, SatisfactionValue> goalSatisfactionMap;

	private Map<Integer, Integer> mapGoalIdNodeId;
	private Map<Integer, Integer> mapNodeIdGoalId;

	public LabelPropagator(GOALMODEL goalModel, GOALMODEL.SCENARIO goalModelScenario) {
		this.goalModel = goalModel;
		this.goalModelScenario = goalModelScenario;
		this.goalSatisfactionMap = new HashMap<Integer, SatisfactionValue>();
		this.mapGoalIdNodeId = new HashMap<Integer, Integer>();
		this.mapNodeIdGoalId = new HashMap<Integer, Integer>();
		for (GOALMODEL.SCENARIO.GOAL goal : goalModelScenario.getGOAL()) {
			this.goalSatisfactionMap.put(goal.getID(),
					new SatisfactionValueAdapter().floatToSatisfactionValue(goal.getSAT()));

		}
		for (GOALMODEL.GRAPH.NODE node : goalModel.getGRAPH().getNODE()) {
			this.mapGoalIdNodeId.put(node.getGOAL(), node.getID());
			this.mapNodeIdGoalId.put(node.getID(), node.getGOAL());
		}
	}

	public GOALMODEL.SCENARIO perform() {

		Map<Integer, SatisfactionValue> currentSatisfactionMap;
		do {
			currentSatisfactionMap = new HashMap<Integer, SatisfactionValue>(goalSatisfactionMap);
			for (GOALMODEL.SCENARIO.GOAL goal : goalModelScenario.getGOAL()) {
				goalSatisfactionMap.put(goal.getID(),
						this.getNewValue(goal, currentSatisfactionMap.get(goal.getID()), currentSatisfactionMap));
			}

		} while (!goalSatisfactionMap.equals(currentSatisfactionMap));

		SatisfactionValueAdapter adapter = new SatisfactionValueAdapter();
		for (GOALMODEL.SCENARIO.GOAL goal : goalModelScenario.getGOAL()) {
			goal.setOUTPUTSAT(adapter.convertSatisfactionValue(goalSatisfactionMap.get(goal.getID())));
		}

		return goalModelScenario;
	}

	private SatisfactionValue getNewValue(GOALMODEL.SCENARIO.GOAL goal, SatisfactionValue oldLabel,
			Map<Integer, SatisfactionValue> currentSatisfactionMap) {

		PropagationRule rule = new PropagationRule();
		SatisfactionValue andDecomposition = null;
		SatisfactionValue orDecomposition = null;
		SatisfactionValue positiveContribution = null;
		SatisfactionValue negativeContribution = null;
		for (GOALMODEL.GRAPH.CONNECTOR transition : goalModel.getGRAPH().getCONNECTOR()) {
			if (transition.getSTARTNODE() == this.mapGoalIdNodeId.get(goal.getID())) {


				// if the transition is due to a decomposition
				if (transition.getTYPE() == 1) {
					SatisfactionValue sourceValue = currentSatisfactionMap
							.get(this.mapNodeIdGoalId.get(transition.getENDNODE()));
					// if it is and decomposed
					if (goal.getOP() == 0) {
						if (andDecomposition == null) {
							andDecomposition = sourceValue;
						} else {
							andDecomposition = rule.getAnd(andDecomposition, sourceValue);
						}

					}
					// if it is or decomposed
					if (goal.getOP() == 1) {
						if (orDecomposition == null) {
							orDecomposition = sourceValue;
						} else {
							orDecomposition = rule.getOr(orDecomposition, sourceValue);
						}
					}

				}
			}
			if (transition.getENDNODE() == this.mapGoalIdNodeId.get(goal.getID())) {
				// if the transition is a contribution
				if (transition.getTYPE() == 0) {
					SatisfactionValue sourceValue = currentSatisfactionMap
							.get(this.mapNodeIdGoalId.get(transition.getSTARTNODE()));
					// it has a positive contribution
					if (transition.getVALUE() == 1) {
						if (positiveContribution == null) {
							positiveContribution = sourceValue;
						} else {
							positiveContribution = rule.getPlusPlus(positiveContribution, sourceValue);
						}
					}
					// it has a negative contribution
					else {
						if (negativeContribution == null) {
							negativeContribution = sourceValue;
						}
						else{
							negativeContribution = rule.getMinusMinus(negativeContribution,
									sourceValue);
						}
					}
				}
			}
		}

		return rule.max(oldLabel, rule.max(andDecomposition,
				rule.max(orDecomposition, rule.max(positiveContribution, negativeContribution))));
	}
}

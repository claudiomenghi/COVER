package it.polimi.chiare;

import java.io.File;
import java.util.List;

import com.google.common.base.Preconditions;

import it.polimi.automata.BA;
import it.polimi.checker.SatisfactionValue;
import it.polimi.checker.intersection.acceptingpolicies.AcceptingPolicy.AcceptingType;
import it.polimi.checker.intersection.acceptingpolicies.BAAcceptingPolicy;
import it.polimi.chiare.checker.InterfaceChecker;
import it.polimi.chiare.labelpropagation.LabelPropagator;
import it.polimi.chiare.models.automata.InterfaceIBA;
import it.polimi.chiare.models.automata.parser.BAIntAdapter;
import it.polimi.chiare.models.goal.GOALMODEL;
import it.polimi.chiare.models.goal.GOALMODEL.SCENARIO.GOAL;
import it.polimi.chiare.models.goal.GoalModelAdapter;
import it.polimi.chiare.utils.SatisfactionValueAdapter;
import it.polimi.model.ltltoba.LTLtoBATransformer;

/**
 * Contains the CHIARE framework.
 * 
 * @author Claudio Menghi
 *
 */
public class COVER {

	/**
	 * The goal model to be considered
	 */
	private final GOALMODEL goalModel;

	/**
	 * The IBA to be analyzed
	 */
	private final InterfaceIBA iba;
	
	private File outputFile;

	/**
	 * creates a new CHIARE object
	 * 
	 * @param goalModel
	 *            the goal model to be considered
	 * @param iba
	 *            the incompleteBA to be considered
	 * @throws NullPointerException
	 *             if one of the parameters is null
	 */
	public COVER(GOALMODEL goalModel, InterfaceIBA iba, File outputFile) {
		Preconditions.checkNotNull(goalModel, "The goal model to be considered cannot be null");
		Preconditions.checkNotNull(iba, "The IBA to be considered cannot be null");
		this.goalModel = goalModel;
		this.iba = iba;
		this.outputFile=outputFile;
	}

	private void check() throws Exception {
		GOALMODEL.SCENARIO currentGoalScenario = goalModel.getSCENARIO().get(goalModel.getSCENARIO().size() - 1);
		List<GOAL> goals = currentGoalScenario.getGOAL();

		GOALMODEL.SCENARIO newScenario = new GOALMODEL.SCENARIO();
		newScenario.setNAME("Scenario: " + (goalModel.getSCENARIO().size() + 1));
		for (GOAL goal : goals) {
			GOAL newGoal = this.cloneGoal(goal);
			
			if(goal.getCAPTION().contains(":")){
				String ltlFormulaString = goal.getCAPTION().substring(goal.getCAPTION().indexOf(":")+2);

				System.out.println(ltlFormulaString);
				LTLtoBATransformer action = new LTLtoBATransformer("!(" + ltlFormulaString + ")");
				BA claimBA = action.perform();

				// check LTL formula
				InterfaceChecker checker = new InterfaceChecker(this.iba, claimBA,
						BAAcceptingPolicy.getAcceptingPolicy(AcceptingType.BA, this.iba, claimBA));

				SatisfactionValue satisfaction = checker.perform();
				
				System.out.println("!(" + ltlFormulaString + ")"+"\t"+satisfaction);
				newGoal.setSAT(new SatisfactionValueAdapter().convertSatisfactionValue(satisfaction));
			}
			newScenario.getGOAL().add(newGoal);
		}
		newScenario=new LabelPropagator(goalModel, newScenario).perform();
		goalModel.getSCENARIO().add(newScenario);


		new GoalModelAdapter().writeGoalModel(this.outputFile, goalModel);
	
	}
	

	private GOAL cloneGoal(GOAL goal){
		GOAL retGoal=new GOAL();
		retGoal.setCAPTION(goal.getCAPTION());
		retGoal.setDEN(goal.getDEN());
		retGoal.setID(goal.getID());
		retGoal.setINPUT(goal.getINPUT());
		retGoal.setINPUTFORCED(goal.getINPUTFORCED());
		retGoal.setLTL(goal.getLTL());
		retGoal.setOP(goal.getOP());
		retGoal.setOUTPUTDEN(goal.getOUTPUTDEN());
		retGoal.setOUTPUTSAT(goal.getOUTPUTSAT());
		retGoal.setSAT(goal.getSAT());
		retGoal.setTOP(goal.getTOP());
		retGoal.setTYPE(goal.getTYPE());
		
		return retGoal;
	}

	/**
	 * runs the CHIARE framework. The framework takes two arguments: the goal
	 * model to be analyzed and the IBA over which the LTL formulae must be
	 * considered.
	 * 
	 * @param args
	 *            it contains the path of the goal model to be analyzed and of
	 *            the IBA which represents the model to be considered
	 * @throws Exception
	 * @throws IllegalArgumentException
	 *             if one of the two parameters is not present or not correct
	 */
	public static void main(String[] args) throws Exception {

		System.out.println(new BAIntAdapter().parseModel(new File(args[1])));
		COVER chiaRE = new COVER(new GoalModelAdapter().parseModel(new File(args[0])),
				new BAIntAdapter().parseModel(new File(args[1])), new File(args[2]));
		chiaRE.check();
	}

}

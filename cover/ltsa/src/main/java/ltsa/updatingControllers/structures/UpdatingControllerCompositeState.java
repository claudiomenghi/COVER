package ltsa.updatingControllers.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import ltsa.lts.CompactState;
import ltsa.lts.CompositeState;
import ltsa.lts.Symbol;
import ltsa.lts.util.MTSUtils;
import MTSTools.ac.ic.doc.mtstools.model.MTS;
import MTSSynthesis.ar.dc.uba.model.condition.Fluent;
import ltsa.control.ControllerGoalDefinition;
import MTSSynthesis.controller.model.gr.GRControllerGoal;

public class UpdatingControllerCompositeState extends CompositeState {

	private CompositeState oldController;
	private CompositeState oldEnvironment;
    private Set<Fluent> oldPropositions;
    private CompositeState newEnvironment;
    private Set<Fluent> newPropositions;
	private ControllerGoalDefinition updateSafetyGoals;
	private GRControllerGoal<String> updateGRGoal;
	private Set<String> controllableActions;
    private PropositionMapping mapping;
	private MTS<Long, String> updateEnvironment;


	public UpdatingControllerCompositeState(CompositeState oldController, CompositeState oldEnvironment, Set<Fluent> oldPropositions,
                                            CompositeState newEnvironment, Set<Fluent> newPropositions, ControllerGoalDefinition newGoal,
                                            GRControllerGoal<String> updateGRGoal, PropositionMapping mapping, String name) {
		super.setMachines(new Vector<CompactState>());
		this.oldController = oldController;
		this.oldEnvironment = oldEnvironment;
        this.oldPropositions = oldPropositions;
        this.newEnvironment = newEnvironment;
        this.newPropositions = newPropositions;
        this.updateSafetyGoals = newGoal;
		this.updateGRGoal = updateGRGoal;
		this.controllableActions = this.updateGRGoal.getControllableActions();
        this.mapping = mapping;

		super.setCompositionType(Symbol.UPDATING_CONTROLLER);
		super.name = name;
	}

	public MTS<Long, String> getUpdateController() {
		return MTSUtils.getMTSComposition(this);
	}

	public MTS<Long, String> getOldController() {
		return MTSUtils.getMTSComposition(oldController);
	}

	public MTS<Long, String> getOldEnvironment() {
		return MTSUtils.getMTSComposition(oldEnvironment);
	}

    public Set<Fluent> getOldPropositions() {
        return oldPropositions;
    }

	public MTS<Long, String> getNewEnvironment() {
		return MTSUtils.getMTSComposition(newEnvironment);
	}

    public Set<Fluent> getNewPropositions() {
        return newPropositions;
    }

	public Set<String> getControllableActions() {
		return controllableActions;
	}

	public List<Fluent> getAllPropositions() {
		List<Fluent> result = new ArrayList<Fluent>();
		result.addAll(oldPropositions);
		result.addAll(newPropositions);
		return result;
	}

	public ControllerGoalDefinition getUpdateSafetyGoals() {
		return updateSafetyGoals;
	}

	public GRControllerGoal<String> getUpdateGRGoal() {
		return updateGRGoal;
	}

    public PropositionMapping getMapping() { return mapping; }

	public MTS<Long, String> getUpdateEnvironment() {
		return updateEnvironment;
	}

	public void setUpdateEnvironment(MTS<Long, String> updateEnvironment) {
		this.updateEnvironment = updateEnvironment;
	}

	@Override
	public UpdatingControllerCompositeState clone() {
		UpdatingControllerCompositeState clone = new UpdatingControllerCompositeState(
				oldController, oldEnvironment, oldPropositions, newEnvironment, newPropositions, updateSafetyGoals,
                updateGRGoal, mapping, name);
		clone.setCompositionType(getCompositionType());
		clone.makeAbstract = makeAbstract;
		clone.makeClousure = makeClousure;
		clone.makeCompose = makeCompose;
		clone.makeDeterministic = makeDeterministic;
		clone.makeMinimal = makeMinimal;
		clone.makeControlStack = makeControlStack;
		clone.makeOptimistic = makeOptimistic;
		clone.makePessimistic = makePessimistic;
		clone.makeController = makeController;
		clone.setMakeComponent(isMakeComponent());
		clone.setComponentAlphabet(getComponentAlphabet());
		clone.goal = goal;
		clone.controlStackEnvironments = controlStackEnvironments;
		clone.controlStackSpecificTier = controlStackSpecificTier;
		clone.isProbabilistic = isProbabilistic;
		return clone;
	}

}
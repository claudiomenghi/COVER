package ltsa.updatingControllers.synthesis;

import MTSSynthesis.ar.dc.uba.model.condition.Fluent;
import MTSSynthesis.ar.dc.uba.model.condition.FluentImpl;
import MTSSynthesis.ar.dc.uba.model.condition.Formula;
import MTSSynthesis.ar.dc.uba.model.language.SingleSymbol;
import MTSSynthesis.controller.model.gr.GRControllerGoal;
import MTSTools.ac.ic.doc.commons.relations.Pair;
import MTSTools.ac.ic.doc.mtstools.model.MTS;
import ltsa.ac.ic.doc.mtstools.util.fsp.MTSToAutomataConverter;
import ltsa.control.ControllerGoalDefinition;
import ltsa.control.util.ControllerUtils;
import ltsa.lts.CompactState;
import ltsa.lts.Diagnostics;
import ltsa.lts.LTSOutput;
import ltsa.lts.Symbol;
import ltsa.lts.chart.util.FormulaUtils;
import ltsa.lts.ltl.AssertDefinition;
import ltsa.updatingControllers.structures.PropositionMapping;
import ltsa.updatingControllers.structures.UpdatingControllerCompositeState;

import java.util.*;

/**
 * Created by lnahabedian on 10/06/15.
 */
public class UpdatingControllerSynthesizer {

	public static void generateController(UpdatingControllerCompositeState uccs, LTSOutput output) {

        Set<String> controllableActions = uccs.getControllableActions();

		// set environment
		MTS<Long, String> oldC = uccs.getOldController();
		MTS<Long, String> oldE = uccs.getOldEnvironment();
        Set<Fluent> oldPropositions = uccs.getOldPropositions();
		MTS<Long, String> newE = uccs.getNewEnvironment();
		Set<Fluent> newPropositions = uccs.getNewPropositions();
        PropositionMapping mapping = uccs.getMapping();
		UpdatingEnvironmentGenerator updEnvGenerator = new UpdatingEnvironmentGenerator(oldC, oldE, oldPropositions, newE, newPropositions, mapping, output);
		updEnvGenerator.generateEnvironment(controllableActions, output);

		solveControlProblem(uccs, updEnvGenerator, output);

	}

	private static void solveControlProblem(
			UpdatingControllerCompositeState uccs, UpdatingEnvironmentGenerator updEnvGenerator, LTSOutput output) {

		MTS<Long, String> environment = updEnvGenerator.getUpdEnv(); // plain E_u
        Pair<List<Formula>,Set<Fluent>> safetyFormulasAndFluents = getSafetyFormulas(uccs.getUpdateSafetyGoals(), output); // plain safety(G_u)
        List<Formula> safetyFormulas = safetyFormulasAndFluents.getFirst();
        Set<Fluent> goalFluents = safetyFormulasAndFluents.getSecond();

        fillTerminatingActions(environment.getActions(), goalFluents); // set the action events fluents terminating with any action

        Set<Fluent> specialFluentsAndActionFluents = new HashSet<Fluent>();
        specialFluentsAndActionFluents.addAll(UpdatingControllersUtils.UPDATE_FLUENTS); // beginUpdate, StopOld, StartNew y Reconf
        specialFluentsAndActionFluents.addAll(UpdatingControllersUtils.ACTION_FLUENTS_FOR_UPDATE); // fluents from events (fluents not defined in .lts)
		MTS<Long, String> metaEnvironment = ControllerUtils.removeTopStates(environment, specialFluentsAndActionFluents);

		output.outln("Environment states:"+ metaEnvironment.getStates().size());
        output.outln("Solving safety goals for the controller synthesis");

        MTS<Long, String> safetyEnv = UpdatingControllerSafetySynthesizer.synthesizeSafety(metaEnvironment, goalFluents, safetyFormulas, uccs.getUpdateGRGoal().getControllableActions());

        output.outln("Environment states after safety: "+ safetyEnv.getStates().size());

        uccs.setUpdateEnvironment(safetyEnv);

        CompactState compactSafetyEnv = MTSToAutomataConverter.getInstance().convert(safetyEnv, "E_u||G(safety)", false);
//		CompactState compactMetaEnv = MTSToAutomataConverter.getInstance().convert(metaEnvironment, "meta E_u", false);
		CompactState compactEnv = MTSToAutomataConverter.getInstance().convert(environment, "E_u", false);

        Vector<CompactState> machines = new Vector<CompactState>();
        machines.add(compactSafetyEnv);
//		machines.add(compactMetaEnv);
//		machines.add(compactEnv);

        uccs.setMachines(machines);

        UpdatingControllerGRSynthesizer.synthesizeGR(compactSafetyEnv, uccs, safetyEnv, output);

        if (uccs.getComposition() == null){
            uccs.setComposition(compactEnv);
            uccs.getMachines().clear();
        }

        UpdatingControllersUtils.ACTION_FLUENTS_FOR_UPDATE.clear();

	}

    /**
     *  get the list of safety formulas from old and new and the set of propositions used in every formula
     *
     * @param newGoalDef
     * @param output
     * @return
     */
    private static Pair<List<Formula>, Set<Fluent>> getSafetyFormulas(ControllerGoalDefinition newGoalDef, LTSOutput output) {
        Set<Fluent> safetyFluents = new HashSet<Fluent>();
        List<Formula> safetyFormulas = new ArrayList<Formula>();
        for (Symbol safetyDefinition : newGoalDef.getSafetyDefinitions()) {

            output.outln("Processing formula for update: " + safetyDefinition.getName());
            AssertDefinition def = AssertDefinition.getConstraint(safetyDefinition.getName());

            if (def != null) {
                safetyFormulas.add(FormulaUtils.adaptFormulaAndCreateFluents(def.getFormula(false), safetyFluents));

            } else {
                Diagnostics.fatal("Assertion not defined ["	+ safetyDefinition.getName() + "].");
            }
        }
        return new Pair<List<Formula>,Set<Fluent>>(safetyFormulas,safetyFluents);
    }

    /**
     * Event actions fluents are define as <"actionName",{}, false>. This method fill
     * the empty set with all actions from the alphabet but not the action "actionName".
     *
     * @param actions
     * @param goalFluents
     */
    private static void fillTerminatingActions(Set<String> actions, Set<Fluent> goalFluents) {

        Set<Fluent> resultantFluents = new HashSet<Fluent>();
        for (Fluent fl : UpdatingControllersUtils.ACTION_FLUENTS_FOR_UPDATE){

            goalFluents.remove(fl);

            Set<MTSSynthesis.ar.dc.uba.model.language.Symbol> terminating = new HashSet<>();
            for (String action : actions){

                if (!action.equals(fl.getName().split("_a")[0])){
                    if (!action.equals("tau")) {
                        terminating.add(new SingleSymbol(action));
                    }
                }
            }

            Fluent resultantFl = new FluentImpl(fl.getName(), fl.getInitiatingActions(), terminating, fl.isInitialValue());
            resultantFluents.add(resultantFl);
            goalFluents.add(resultantFl);
        }

        UpdatingControllersUtils.ACTION_FLUENTS_FOR_UPDATE.clear();
        UpdatingControllersUtils.ACTION_FLUENTS_FOR_UPDATE.addAll(resultantFluents);
    }



}

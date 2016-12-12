package ltsa.updatingControllers.synthesis;

import java.util.*;

import ltsa.control.util.ControllerUtils;
import ltsa.lts.LTSOutput;

import MTSTools.ac.ic.doc.mtstools.model.impl.LTKS;

import ltsa.updatingControllers.UpdateConstants;
import MTSTools.ac.ic.doc.commons.relations.Pair;
import MTSTools.ac.ic.doc.mtstools.model.MTS;
import MTSSynthesis.ar.dc.uba.model.condition.Fluent;
import ltsa.updatingControllers.structures.PropositionMapping;

public class UpdatingEnvironmentGenerator {

    private LTKS oldEnvironment;
    private LTKS newEnvironment;
    private LTKS updatingEnvironment;
	private Long lastState;
	private Set<Long> eParallelCStates; // used for relabeling actions
	private Set<Long> oldEnvironmentStates;
    private LTSOutput output;

	public UpdatingEnvironmentGenerator(MTS<Long, String> oldController, MTS<Long, String> oldEnv, Set<Fluent> oldProps,
        		MTS<Long, String> newEnv, Set<Fluent> newProps, PropositionMapping mapping, LTSOutput output) {

		this.embed(oldEnv, oldProps, newEnv, newProps, mapping);

		updatingEnvironment = new LTKS(oldController, oldProps, oldController.getActions()); // begins with the old controller
        lastState = new Long(Collections.max(updatingEnvironment.getStates()));

		eParallelCStates = new HashSet<>(updatingEnvironment.getStates());
		oldEnvironmentStates = new HashSet<Long>();
        this.output = output;
	}

	public void generateEnvironment(Set<String> controllableActions, LTSOutput output) {
		
		this.checkLTKS(oldEnvironment, "old environment");
        this.checkLTKS(newEnvironment, "new environment");

        // here updatingEnvironment is E||C
        Map<Long, Long> oldEnvToUpdEnv = linkOldStatesWithBeginUpdate();
        completeWithOldEnvironment(oldEnvToUpdEnv);
        // here updatingEnvironment is E||C -> E
		Map<Long, Long> newEnvToUpdEnv = this.linkStatesWithReconfigure(oldEnvToUpdEnv);
		this.completeWithNewEnvironment(newEnvToUpdEnv);
        // here updatingEnvironment is E||C -> E -> E'
	}

    private void checkLTKS(LTKS ltks, String name) {

        Set<Set<Fluent>> visitedValuations = new HashSet<Set<Fluent>>();
        for (Long state : ltks.getStates()){
            Set<Fluent> stateValuation = ltks.getValuation(state);
            if (visitedValuations.contains(stateValuation)){
                output.outln("WARNING two states with the same valuation in "+ name + ":");
				String message = "{";
				if (stateValuation.size() == 0){
					message = "{}";
				} else {
					for (Fluent fl : stateValuation){
						message = message.concat(fl.getName()+ ",");
					}
					message = message.substring(0, message.length()-1).concat("}");
				}
                output.outln(message);
            } else {
				visitedValuations.add(stateValuation);
			}
        }
	}

    private void embed(MTS oldEnv, Set<Fluent> oldProps, MTS newEnv, Set<Fluent> newProps, PropositionMapping mapping) {

        Set<Fluent> allProps = new HashSet<>(oldProps);
        allProps.addAll(newProps);
        Set<String> allActions = new HashSet<String>(oldEnv.getActions());
        allActions.addAll(newEnv.getActions());

        oldEnvironment = new LTKS(oldEnv, allProps, allActions);
        newEnvironment = new LTKS(newEnv, allProps, allActions);

        if (mapping.isDefined()) {
            oldEnvironment.embed(mapping);
            newEnvironment.embed(mapping);
        }

    }

    /////////////////////////////////// begin update link //////////////////////////////////////////////


    private Map<Long, Long> linkOldStatesWithBeginUpdate() {

        updatingEnvironment.addAction(UpdateConstants.BEGIN_UPDATE);

        HashMap<Long, Long> oldEnvToUpdEnv = new HashMap<Long, Long>();
        for (Long controllerState : eParallelCStates){

            Set<Fluent> controllerValuation = updatingEnvironment.getValuation(controllerState);

            for (Long oldEnvironmentState : oldEnvironment.getStates()){
                Set<Fluent> oldEnvValuation = oldEnvironment.getValuation(oldEnvironmentState);

                if (sameOldValuation(controllerValuation, oldEnvValuation)){

                    addBeginUpdateTransition(controllerState, oldEnvToUpdEnv, oldEnvironmentState);
                }
            }
        }

        return oldEnvToUpdEnv;

    }

	private boolean sameOldValuation(Set<Fluent> controllerValuation, Set<Fluent> oldEnvValuation) {

        for (Fluent originalProp : updatingEnvironment.getPropositions()){
            if (controllerValuation.contains(originalProp) && !oldEnvValuation.contains(originalProp)) {
                return false;
            } else if (!controllerValuation.contains(originalProp) && oldEnvValuation.contains(originalProp))
                return false;
        }

        return true;

	}

//    private void generateOldPart() {
//
//		oldPart.addAction(UpdateConstants.BEGIN_UPDATE);
//
//		// add beginUpdate transition and the new state from (0,0)
//		addBeginUpdateTransition(oldPart.getInitialState());
//
//		// BFS
//		Queue<Pair<Long, Long>> toVisit = new LinkedList<Pair<Long, Long>>();
//		Pair<Long, Long> firstState = new Pair<Long, Long>(oldController.getInitialState(), oldEnvironment.getInitialState());
//		toVisit.add(firstState);
//		ArrayList<Pair<Long, Long>> discovered = new ArrayList<Pair<Long, Long>>();
//
//		while (!toVisit.isEmpty()) {
//			Pair<Long, Long> actual = toVisit.remove();
//			if (!discovered.contains(actual)) {
//				discovered.add(actual);
//				for (Pair<String, Long> action_toState : oldController.getTransitions(actual.getFirst(), MTS.TransitionType.REQUIRED)) {
//					toVisit.addAll(nextToVisitInParallelComposition(actual, action_toState));
//				}
//			}
//		}
//	}

//	private ArrayList<Pair<Long, Long>> nextToVisitInParallelComposition(Pair<Long, Long> actual, Pair<String, Long>
//		transition) {
//
//		ArrayList<Pair<Long, Long>> toVisit = new ArrayList<Pair<Long, Long>>();
//
//		for (Pair<String, Long> action_toStateEnvironment : oldEnvironment.getTransitionsFrom(actual.getSecond())) {
//
//			String action = action_toStateEnvironment.getFirst();
//			Long toState = action_toStateEnvironment.getSecond();
//
//			if (transition.getFirst().equals(action)) {
//
//				//action = action.concat(UpdateControllerSolver.label); // rename the actions so as to
//				// distinguish from the controllable in the new problem controller
//				oldPart.addAction(action); // actions is a Set. it Avoids duplicated actions
//				Pair<Long, Long> newState = new Pair<Long, Long>(transition.getSecond(), toState);
//				oldPart.addState(newState);
//
//				addBeginUpdateTransition(newState);
//				oldPart.addRequired(new Pair<Long, Long>(actual.getFirst(), actual.getSecond()), action, newState);
//				toVisit.add(new Pair<Long, Long>(transition.getSecond(), toState));
//			}
//		}
//
//		return toVisit;
//	}

	private void addBeginUpdateTransition(Long from, Map<Long,Long> oldEnvToUpdEnv, Long originalOldEnvState) {

        if (oldEnvToUpdEnv.containsKey(originalOldEnvState)) {
            Long toState = oldEnvToUpdEnv.get(originalOldEnvState);
            updatingEnvironment.addTransition(from, UpdateConstants.BEGIN_UPDATE, toState);
        } else {
            Long freshState = new Long(lastState + 1);
            updatingEnvironment.addState(freshState);
            updatingEnvironment.addTransition(from, UpdateConstants.BEGIN_UPDATE, freshState);

            oldEnvToUpdEnv.put(originalOldEnvState, freshState);
            oldEnvironmentStates.add(freshState);
            addStopOldAndStartNewSpecActions(freshState);
            lastState++;
        }
    }

	private void completeWithOldEnvironment(Map<Long, Long> oldEnvToUpdEnv) {

        for (Long originalOldEnvState : oldEnvironment.getStates()) {

            for (Pair<String, Long> action_toState : oldEnvironment.getTransitionsFrom(originalOldEnvState)) {

                if (oldEnvToUpdEnv.containsKey(originalOldEnvState)) {

                    Long updEnvState = oldEnvToUpdEnv.get(originalOldEnvState);
                    Set<Long> freshState = addTransitionCreatingNewStates(action_toState, updEnvState, oldEnvToUpdEnv);
                    oldEnvironmentStates.addAll(freshState);
                    addStopOldAndStartNewSpecActions(freshState);
                } else {

                    Long freshUpdEnvState = addState(originalOldEnvState, oldEnvToUpdEnv);
                    oldEnvironmentStates.add(freshUpdEnvState);
                    addStopOldAndStartNewSpecActions(freshUpdEnvState);
                    Set<Long> freshState = addTransitionCreatingNewStates(action_toState, freshUpdEnvState, oldEnvToUpdEnv);
                    oldEnvironmentStates.addAll(freshState);
                    addStopOldAndStartNewSpecActions(freshState);

                }
            }
        }
	}

//	private void changePairsToLong() {
//
//        updatingEnvironment.setPropositions(oldEnvironment.getPropositions());
//		Map<Pair<Long, Long>, Long> visited = new HashMap<Pair<Long, Long>, Long>();
//
//		// set first the state (0,0) to 0
//		Pair<Long, Long> initialPair = new Pair<Long, Long>(new Long(0), new Long(0));
//		Long initialState = this.getState(visited, initialPair);
//        updatingEnvironment.setInitialState(initialState);
//        this.copyActions(visited, initialState, initialPair);
//
//		for (Pair<Long, Long> pairState : oldPart.getStates()) {
//
//			Long from = this.getState(visited, pairState);
//			this.copyActions(visited, from, pairState);
//
//            Long envState = pairState.getSecond(); // oldEnvironment state (is never -1)
//            updatingEnvironment.setValuation(from, oldEnvironment.getValuation(envState));
//		}
//    }

//    private Long getState(Map<Pair<Long, Long>, Long> visited, Pair<Long, Long> pairState) {
//		Long state = null;
//		if (visited.containsKey(pairState)) {
//			state = visited.get(pairState);
//		} else {
//			visited.put(pairState, lastState);
//			state = lastState;
//			updatingEnvironment.addState(state);
//			lastState++;
//		}
//		return state;
//	}

//	private void copyActions(Map<Pair<Long, Long>, Long> visited, Long longState, Pair<Long, Long> pairState) {
//
//		for (Pair<String, Pair<Long, Long>> action_toState : oldPart.getTransitions(pairState, TransitionType.REQUIRED)) {
//
//			String action = action_toState.getFirst();
//			Pair<Long, Long> toPairState = action_toState.getSecond();
//			updatingEnvironment.addAction(action);
//
//			Long to = getState(visited, toPairState);
//			updatingEnvironment.addTransition(longState, action, to);
//
//		}
//	}

    /////////////////////////////////// reconfigure link //////////////////////////////////////////////

    private void checkSplittedStates() {

        for (Long state : oldEnvironmentStates){
            if (eParallelCStates.contains(state)){
                output.outln("ERRRRROOOOOOOOOOORRRRRR 1");
            }
        }
        for (Long state : eParallelCStates){
            if (oldEnvironmentStates.contains(state)){
                output.outln("ERRRRROOOOOOOOOOORRRRRR 2");
            }
        }

    }

    private void addStopOldAndStartNewSpecActions(Set<Long> freshState) {
        if (freshState.isEmpty()) return;
        addStopOldAndStartNewSpecActions(freshState.iterator().next());
    }

    private void addStopOldAndStartNewSpecActions(Long state) {
        updatingEnvironment.addAction(UpdateConstants.STOP_OLD_SPEC);
        updatingEnvironment.addAction(UpdateConstants.START_NEW_SPEC);
        updatingEnvironment.addTransition(state, UpdateConstants.STOP_OLD_SPEC, state);
        updatingEnvironment.addTransition(state, UpdateConstants.START_NEW_SPEC, state);
    }

	private HashMap<Long, Long> linkStatesWithReconfigure(Map<Long, Long> oldEnvToUpdEnv) {

		checkSplittedStates();

		updatingEnvironment.addAction(UpdateConstants.RECONFIGURE);

		HashMap<Long, Long> newEnvToUpdEnv = new HashMap<Long, Long>();
        for (Long oldEnvState : oldEnvironment.getStates()){

            Set<Fluent> oldValuation = oldEnvironment.getValuation(oldEnvState);

            for (Long newEnvironmentState : newEnvironment.getStates()){
                Set<Fluent> newValuation = newEnvironment.getValuation(newEnvironmentState);

                if (sameValuation(oldValuation, newValuation)){
					addReconfigureAction(newEnvToUpdEnv, oldEnvToUpdEnv.get(oldEnvState), newEnvironmentState);
				}
            }
        }

		return newEnvToUpdEnv;
	}

    private boolean sameValuation(Set<Fluent> oldValuation, Set<Fluent> newValuation) {

        return oldValuation.equals(newValuation);
    }

    private void addReconfigureAction(HashMap<Long, Long> newEnvToUpdEnv, Long oldEnvState, Long newEnvironmentState) {
		if (newEnvToUpdEnv.containsKey(newEnvironmentState)) {
            Long toState = newEnvToUpdEnv.get(newEnvironmentState);
            updatingEnvironment.addTransition(oldEnvState, UpdateConstants.RECONFIGURE, toState);
        } else {
            Long newState = new Long(lastState + 1);
            updatingEnvironment.addState(newState);
            updatingEnvironment.addTransition(oldEnvState, UpdateConstants.RECONFIGURE, newState);

            newEnvToUpdEnv.put(newEnvironmentState, newState);
            lastState++;
        }
	}

	private void completeWithNewEnvironment(Map<Long, Long> newEnvToUpdEnv) {

		for (Long state : newEnvironment.getStates()) {

			for (Pair<String, Long> action_toState : newEnvironment.getTransitionsFrom(state)) {

				if (newEnvToUpdEnv.containsKey(state)) {

					Long updEnvState = newEnvToUpdEnv.get(state);
					addTransitionCreatingNewStates(action_toState, updEnvState, newEnvToUpdEnv);
					addStopOldAndStartNewSpecActions(updEnvState);
				} else {

					Long updEnvState = addState(state, newEnvToUpdEnv);
					addTransitionCreatingNewStates(action_toState, updEnvState, newEnvToUpdEnv);
					addStopOldAndStartNewSpecActions(updEnvState);
				}
			}
		}
	}

    /**
     *
     * @param action_toState
     * @param state
     * @param envToUpdEnv
     * @return empty set if not fresh state was created. A set with the new state if a fresh state was created
     */
	private Set<Long> addTransitionCreatingNewStates(Pair<String, Long> action_toState, Long state, Map<Long, Long> envToUpdEnv) {

        Set<Long> result = new HashSet<Long>();
		updatingEnvironment.addAction(action_toState.getFirst());
		if (!envToUpdEnv.containsKey(action_toState.getSecond())) {

			Long freshUpdEnvState = addState(action_toState.getSecond(), envToUpdEnv);
			updatingEnvironment.addTransition(state, action_toState.getFirst(), freshUpdEnvState);
            result.add(freshUpdEnvState);

		} else {
			updatingEnvironment.addTransition(state, action_toState.getFirst(), envToUpdEnv.get(action_toState.getSecond()));
		}
        return result;
	}

	private Long addState(Long originalState, Map<Long, Long> envToUpdEnv) {

		Long newState = new Long(lastState + 1);
		updatingEnvironment.addState(newState);
		envToUpdEnv.put(originalState, newState);
		lastState++;
		return newState;
	}

	public MTS<Long, String> getUpdEnv(){
		return ControllerUtils.LTKS2MTS(updatingEnvironment);
	}

}
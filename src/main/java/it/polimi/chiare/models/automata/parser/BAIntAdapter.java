package it.polimi.chiare.models.automata.parser;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.google.common.base.Preconditions;

import it.polimi.automata.io.in.propositions.StringToClaimPropositions;
import it.polimi.automata.state.State;
import it.polimi.automata.state.StateFactory;
import it.polimi.automata.transition.ClaimTransitionFactory;
import it.polimi.automata.transition.TransitionFactory;
import it.polimi.chiare.models.automata.InterfaceIBA;


public class BAIntAdapter {

	public InterfaceIBA parseModel(File file) throws JAXBException {
		Preconditions.checkNotNull(file, "The file to be considered cannot be null");
		JAXBContext jaxbContext = JAXBContext.newInstance(BAINTPARSER.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		BAINTPARSER parsedBA = (BAINTPARSER) jaxbUnmarshaller.unmarshal(file);

		InterfaceIBA baInt = new InterfaceIBA(new ClaimTransitionFactory());

		StateFactory stateFactory = new StateFactory();
		TransitionFactory<State, it.polimi.automata.transition.Transition> transitionFactory = new ClaimTransitionFactory();
		for (BAINTPARSER.Propositions.Proposition proposition : parsedBA.propositions.getProposition()) {

			baInt.addPropositions(new StringToClaimPropositions().transform(proposition.name));

		}

		Map<Integer, State> mapIdState = new HashMap<Integer, State>();
		for (BAINTPARSER.States.State state : parsedBA.states.getState()) {
			State newstate = stateFactory.create(state.getName(), state.getId().intValue());
			baInt.addState(newstate);
			if (state.initial!=null && state.initial) {
				baInt.addInitialState(newstate);
			}
			if (state.accepting!=null && state.accepting) {
				baInt.addAcceptState(newstate);
			}
			if(state.blackbox!=null && state.blackbox){
				baInt.addBlackBoxState(newstate);
			}
			mapIdState.put(newstate.getId(), newstate);
			if( state._interface!=null){
				for (BAINTPARSER.States.State.Interface.Proposition proposition : state._interface.getProposition()) {
					if(proposition!=null && proposition.getName()!=null){
						baInt.addPropositonToInterface(newstate, new StringToClaimPropositions().transform(proposition.getName()));
					}
					
				}
			}
			
		}
		for (Transition transition : parsedBA.transitions.getTransition()) {

			it.polimi.automata.transition.Transition newTransition = transitionFactory.create(transition.id.intValue(),
					new StringToClaimPropositions().transform(transition.propositions));

			baInt.addTransition(mapIdState.get(transition.source.intValue()),
					mapIdState.get(transition.destination.intValue()), newTransition);
		}

		return baInt;

	}
}

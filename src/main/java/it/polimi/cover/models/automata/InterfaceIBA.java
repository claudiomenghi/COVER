package it.polimi.cover.models.automata;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.checkerframework.checker.nullness.qual.NonNull;

import com.google.common.base.Preconditions;

import it.polimi.automata.IBA;
import it.polimi.automata.state.State;
import it.polimi.automata.transition.Transition;
import it.polimi.automata.transition.TransitionFactory;
import rwth.i2.ltl2ba4j.model.IGraphProposition;

public class InterfaceIBA extends IBA {

	private Map<State, Set<IGraphProposition>> stateInterfaces = new HashMap<State, Set<IGraphProposition>>();

	public InterfaceIBA(@NonNull TransitionFactory<@NonNull State, @NonNull Transition> transitionFactory) {
		super(transitionFactory);

	}

	public void setInterface(State state, Set<IGraphProposition> propositions) {
		this.stateInterfaces.put(state, propositions);
	}

	public void addPropositonToInterface(State state, Set<IGraphProposition> propositions) {
		Preconditions.checkArgument(this.getPropositions().containsAll(propositions),
				"There is one proposition in the interface " + propositions
						+ " which is not contained in the alphabet of the automaton");
		
		if (this.stateInterfaces.containsKey(state)) {
			this.stateInterfaces.get(state).addAll(propositions);
		} else {
			this.stateInterfaces.put(state, propositions);
		}
	}

	public Set<IGraphProposition> getInterface(State state) {
		return this.stateInterfaces.get(state);
	}

	public String toString() {
		String retString = super.toString();
		StringBuilder builder = new StringBuilder(retString);
		for (Entry<State, Set<IGraphProposition>> interfaces : stateInterfaces.entrySet()) {
			builder.append(interfaces);
		}
		return builder.toString();
	}
}

package MTSTools.ac.ic.doc.mtstools.model.impl;

import MTSSynthesis.ar.dc.uba.model.condition.Fluent;
import MTSSynthesis.ar.dc.uba.model.condition.FluentUtils;
import MTSSynthesis.controller.game.util.FluentStateValuation;
import MTSTools.ac.ic.doc.commons.relations.BinaryRelation;
import MTSTools.ac.ic.doc.commons.relations.MapSetBinaryRelation;
import MTSTools.ac.ic.doc.commons.relations.Pair;
import MTSTools.ac.ic.doc.mtstools.model.MTS;
import MTSTools.ac.ic.doc.mtstools.model.TransitionSystem;
import ltsa.control.util.ControllerUtils;
import ltsa.updatingControllers.structures.PropositionMapping;
import org.apache.commons.collections15.CollectionUtils;
import org.apache.commons.collections15.iterators.EntrySetMapIterator;
import org.apache.commons.lang.Validate;

import java.util.*;

/**
 * Created by lnahabedian on 31/08/16.
 */
public class LTKS implements TransitionSystem<Long,String> {

    private Set<Long> states;
    private Set<String> actions;
    private Map<Long, BinaryRelation<String, Long>> transitions;
    private Set<Fluent> propositions;
    private FluentStateValuation<Long> valuations;
    private Long initialState;

    public LTKS(MTS<Long, String> automaton, Set<Fluent> props, Set<String> acts) {

        automaton.addActions(acts);
        automaton = ControllerUtils.removeTopStates(automaton, props);
        initialState = automaton.getInitialState();
        states = new HashSet<Long>(automaton.getStates());
        actions = new HashSet<>(acts);
        transitions = automaton.getTransitions(MTS.TransitionType.REQUIRED);
        propositions = props;
        valuations = FluentUtils.getInstance().buildValuation(automaton, this.propositions);
    }

    @Override
    public Set<Long> getStates() {
        return states;
    }

    @Override
    public Set<String> getActions() {
        return actions;
    }

    @Override
    public Long getInitialState() {
        return initialState;
    }

    @Override
    public boolean addState(Long state) {
        if (states.add(state)) {
            this.transitions.put(state, this.newRelation());
            this.valuations.addState(state);
            return true;
        }
        return false;
    }

    protected BinaryRelation<String, Long> newRelation() {
        return new MapSetBinaryRelation<String, Long>();
    }

    @Override
    public boolean addStates(Collection<? extends Long> states){
        if (this.states.addAll(states)){
            for (Long state : states){
                this.transitions.put(state,this.newRelation());
                this.valuations.addState(state);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean addAction(String action) {
        return actions.add(action);
    }

    @Override
    public boolean addActions(Collection<? extends String> actions) {
        return this.actions.addAll(actions);
    }

    @Override
    public void removeAction(String action) {
        actions.remove(action);
    }

    @Override
    public boolean removeUnreachableStates() {

        Long state = getInitialState();
        Collection<Long> reachableStates = getReachableStatesBy(state);
        Collection<Long> unreachable = CollectionUtils.subtract(getStates(), reachableStates);
        this.removeStates(unreachable);
        return !unreachable.isEmpty();

    }

    protected Collection<Long> getReachableStatesBy(Long state) {
        Collection<Long> reachableStates = new HashSet<Long>((int) (this.getStates().size() / .75f + 1), 0.75f);
        Queue<Long> toProcess = new LinkedList<Long>();
        toProcess.offer(state);
        reachableStates.add(state);
        while (!toProcess.isEmpty()) {
            for (Pair<String, Long> transition : getTransitionsFrom(toProcess.poll())) {
                if (!reachableStates.contains(transition.getSecond())) {
                    toProcess.offer(transition.getSecond());
                    reachableStates.add(transition.getSecond());
                }
            }
        }
        return reachableStates;
    }

    public BinaryRelation<String, Long> getTransitionsFrom(Long state) {
        return transitions.get(state);
    }

    @Override
    public void setInitialState(Long state) {
        initialState = state;
    }

    protected void removeStates(Collection<Long> toRemove) {
        this.removeTransitions(toRemove);
        states = new HashSet<Long>(CollectionUtils.subtract(getStates(), toRemove));    }

    protected void removeTransitions(Collection<Long> toRemove) {
        transitions.keySet().removeAll(toRemove);
        for (BinaryRelation<String, Long> rel : transitions.values()) {
            for (Iterator<Pair<String, Long>> iter = rel.iterator(); iter.hasNext(); ) {
                Long state = iter.next().getSecond();
                if (toRemove.contains(state)) {
                    iter.remove();
                }
            }
        }
    }

    public Set<Fluent> getValuation(Long state) {
        return valuations.getFluentsFromState(state);
    }

    public Set<Fluent> getPropositions(){
        return this.propositions;
    }

    public void addPropositions(Collection<Fluent> props){
        this.propositions.addAll(props);
    }

    public boolean addTransition(Long from, String label, Long to) {
        this.validateNewTransition(from, label, to);
        boolean added = this.getTransitionsFrom(from).addPair(label, to);
        return added;
    }

    protected void validateNewTransition(Long from, String label, Long to) {
        Validate.isTrue(this.actions.contains(label), "Action: " + label + " is not in the alphabet");
        Validate.isTrue(this.states.contains(from), "State: " + from + " doesn't exists.");
        Validate.isTrue(this.states.contains(to), "State: " + to + " doesn't exists.");

    }

    public void setValuation(Long from, Set<Fluent> valuation) {
        for (Fluent fl : valuation){
            Validate.isTrue(this.propositions.contains(fl), "Proposition: " + fl.getName() + " is not in the LTKS proposition set" );
            this.valuations.addHoldingFluent(from, fl);
        }
    }

    public void setPropositions(Set<Fluent> propositions) {
        this.propositions = propositions;
    }

    public Map<Long,BinaryRelation<String,Long>> getTransitions() {
        return transitions;
    }

    public void embed(PropositionMapping mapping) {

        Set<Long> toRemove = new HashSet<Long>();
        for (Long state : states){
            Set<Fluent> valuation = valuations.getFluentsFromState(state);
            if (! mapping.validate(valuation)){
                toRemove.add(state);
            }
        }

        if (! toRemove.isEmpty()) {
            removeStates(toRemove);
            removeUnreachableStates();
        }

    }
}

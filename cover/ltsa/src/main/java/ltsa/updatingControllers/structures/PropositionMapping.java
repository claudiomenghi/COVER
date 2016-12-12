package ltsa.updatingControllers.structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import MTSTools.ac.ic.doc.commons.relations.Pair;
import MTSTools.ac.ic.doc.mtstools.model.MTS;
import MTSSynthesis.ar.dc.uba.model.condition.Fluent;
import MTSSynthesis.ar.dc.uba.model.condition.FluentUtils;
import MTSSynthesis.controller.game.util.FluentStateValuation;
import ltsa.lts.Symbol;
import ltsa.updatingControllers.synthesis.UpdatingControllersUtils;

public class PropositionMapping {

    private List<MappingRule> rules;

    public PropositionMapping(List<Pair<List<Symbol>, List<Symbol>>> parsedMapping){

        rules = new ArrayList<MappingRule>();
        if (parsedMapping == null) { return; }
        for (Pair<List<Symbol>,List<Symbol>> pair : parsedMapping){
            HashSet<Fluent> left = new HashSet<>(UpdatingControllersUtils.compileFluents(pair.getFirst()));
            HashSet<Fluent> right = new HashSet<>(UpdatingControllersUtils.compileFluents(pair.getSecond()));
            rules.add(new MappingRule(left, right));
        }
    }


    public List<MappingRule> getRules() {
        return rules;
    }

    public boolean validate(Set<Fluent> valuation) {

        for (MappingRule rule : rules){
            if (! rule.validate(valuation)){
                return false;
            }
        }
        return true;
    }

    public boolean isDefined() {
        return rules.size() > 0;
    }
}


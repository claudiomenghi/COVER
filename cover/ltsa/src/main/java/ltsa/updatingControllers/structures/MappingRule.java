package ltsa.updatingControllers.structures;

import MTSSynthesis.ar.dc.uba.model.condition.Fluent;
import org.apache.commons.collections.CollectionUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lnahabedian on 9/8/16.
 */
public class MappingRule {

    private Set<Fluent> preCondition;
    private Set<Fluent> postCondition;

    public MappingRule(HashSet<Fluent> pre, HashSet<Fluent> post) {

        preCondition = pre;
        postCondition = post;

    }

    public boolean validate(Set<Fluent> valuation) {

        if (!valuation.containsAll(preCondition)){
            return true;
        } else {
            return valuation.containsAll(postCondition);
        }
    }
}

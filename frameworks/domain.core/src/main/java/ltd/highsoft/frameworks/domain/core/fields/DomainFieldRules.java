package ltd.highsoft.frameworks.domain.core.fields;

import java.util.*;

public class DomainFieldRules<DomainFieldType> {

    private final List<DomainFieldRule<DomainFieldType>> rules;

    public DomainFieldRules() {
        this.rules = new ArrayList<>();
    }

    public void add(DomainFieldRule<DomainFieldType> rule) {
        this.rules.add(rule);
    }

    void verify(DomainFieldType value) {
        this.rules.forEach(o -> o.verify(value));
    }

}

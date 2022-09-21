package ltd.highsoft.frameworks.domain.core.fields;

import ltd.highsoft.frameworks.domain.core.GlobalIdGenerator;

import static ltd.highsoft.frameworks.domain.core.fields.DomainFieldRule.Anything.anything;
import static ltd.highsoft.frameworks.domain.core.fields.DomainFieldRule.StringThing.string;

public class Id extends DomainField<String> {

    public Id() {
        this(GlobalIdGenerator.nextId());
    }

    public Id(String id) {
        super(id);
        final int uuidSize = 32;
        addRule(anything().notNull());
        addRule(string().notEmpty());
        addRule(string().maxLength(uuidSize));
    }

}

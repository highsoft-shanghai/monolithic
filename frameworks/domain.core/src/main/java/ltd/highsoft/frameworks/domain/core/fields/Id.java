package ltd.highsoft.frameworks.domain.core.fields;

import ltd.highsoft.frameworks.domain.core.GlobalIdGenerator;

import static ltd.highsoft.frameworks.domain.core.fields.DomainFieldRule.*;

public class Id extends DomainField<String> {

    public Id() {
        this(GlobalIdGenerator.nextId());
    }

    public Id(String id) {
        super(id);
        this.withRule(notNull());
        this.withRule(maxLength(32));
    }

}

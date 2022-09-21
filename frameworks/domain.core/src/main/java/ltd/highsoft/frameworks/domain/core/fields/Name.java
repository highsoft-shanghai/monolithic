package ltd.highsoft.frameworks.domain.core.fields;

import static ltd.highsoft.frameworks.domain.core.fields.DomainFieldRule.Anything.anything;
import static ltd.highsoft.frameworks.domain.core.fields.DomainFieldRule.StringThing.string;

public class Name extends DomainField<String> {

    public Name(String name) {
        super(name);
        final int maxSize = 200;
        addRule(anything().notNull());
        addRule(string().notEmpty());
        addRule(string().maxLength(maxSize));
    }

}

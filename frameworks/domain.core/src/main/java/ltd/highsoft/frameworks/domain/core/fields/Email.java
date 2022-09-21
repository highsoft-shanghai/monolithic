package ltd.highsoft.frameworks.domain.core.fields;

import static ltd.highsoft.frameworks.domain.core.fields.DomainFieldRule.Anything.anything;
import static ltd.highsoft.frameworks.domain.core.fields.DomainFieldRule.StringThing.string;

public class Email extends DomainField<String> {

    public Email(String value) {
        super(value);
        final int maxSize = 200;
        final String emailRegex = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        addRule(anything().notNull());
        addRule(string().notEmpty());
        addRule(string().maxLength(maxSize));
        addRule(string().regex(emailRegex));
    }

}

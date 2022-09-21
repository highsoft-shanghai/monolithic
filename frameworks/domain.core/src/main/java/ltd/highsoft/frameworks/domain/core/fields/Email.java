package ltd.highsoft.frameworks.domain.core.fields;

import static ltd.highsoft.frameworks.domain.core.fields.DomainFieldRule.StringThing.string;

public class Email extends InputContent {

    public Email(String value) {
        super(value);
        final String emailRegex = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        addRule(string().regex(emailRegex));
    }

}

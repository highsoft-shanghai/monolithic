package ltd.highsoft.frameworks.domain.core.fields;

import static ltd.highsoft.frameworks.domain.core.fields.DomainFieldRule.StringThing.string;

public final class Email extends GeneralInformation {

    public Email(String value) {
        super(value);
        final String emailRegex = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        addRule(string().regex(emailRegex, "error.email-not-match-format"));
    }

}

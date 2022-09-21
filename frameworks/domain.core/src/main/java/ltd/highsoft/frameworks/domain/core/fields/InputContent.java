package ltd.highsoft.frameworks.domain.core.fields;

import static ltd.highsoft.frameworks.domain.core.fields.DomainFieldRule.Anything.anything;
import static ltd.highsoft.frameworks.domain.core.fields.DomainFieldRule.StringThing.string;

public class InputContent extends DomainField<String> {

    public InputContent(String content) {
        super(content);
        final int maxSize = 200;
        addRule(anything().notNull());
        addRule(string().notEmpty());
        addRule(string().maxLength(maxSize));
    }

}

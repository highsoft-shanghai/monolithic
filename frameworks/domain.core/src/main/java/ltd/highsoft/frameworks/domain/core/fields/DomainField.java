package ltd.highsoft.frameworks.domain.core.fields;

import lombok.*;

@Getter
@EqualsAndHashCode(exclude = "rules")
public class DomainField<Type> {

    private final Type value;
    private final DomainFieldRules<Type> rules = new DomainFieldRules<>();

    protected DomainField(Type value) {
        this.value = value;
    }

    protected void addRule(DomainFieldRule<Type> rule) {
        this.rules.add(rule);
    }

    public void verify() {
        rules.verify(value);
    }

    public Type get() {
        return value;
    }

}

package ltd.highsoft.frameworks.domain.core.fields;

public class DomainField<Type> {

    private final Type value;
    private final DomainFieldRules<Type> rules;

    protected DomainField(Type value, DomainFieldRules<Type> rules) {
        this.value = value;
        this.rules = rules;
    }

    public void verify() {
        rules.verify(value);
    }

    public Type get() {
        return value;
    }

}

package ltd.highsoft.frameworks.domain.core.fields;

public abstract class DomainField<T> {

    private final T value;
    private final String errorMessage;

    protected DomainField(T value, String errorMessage) {
        this.value = value;
        this.errorMessage = errorMessage;
    }

    public void verify() {
        if (notAllowed()) throw new NotAllowedValueInDomainException(null);
    }

    public abstract boolean notAllowed();

    public T get() {
        return value;
    }

}

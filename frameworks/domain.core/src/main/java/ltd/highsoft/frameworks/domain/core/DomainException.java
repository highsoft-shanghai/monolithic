package ltd.highsoft.frameworks.domain.core;

public class DomainException extends RuntimeException {

    private final Object[] data;

    public DomainException() {
        this.data = new Object[]{};
    }

    public DomainException(String code, Object... data) {
        super(code);
        this.data = data;
    }

    public String format(MessageResolver resolver) {
        return resolver.resolve(getMessage(), data);
    }

}

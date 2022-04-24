package ltd.highsoft.frameworks.domain.core;

public class DomainException extends RuntimeException {

    private static final Object[] EMPTY_DATA = {};
    private final Object[] data;

    public DomainException() {
        this.data = EMPTY_DATA;
    }

    public DomainException(String code, Object... data) {
        super(code);
        this.data = data;
    }

    public String format(MessageResolver resolver) {
        return resolver.resolve(getMessage(), data);
    }

}

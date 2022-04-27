package ltd.highsoft.frameworks.domain.core;

import java.util.List;

public class DomainException extends RuntimeException {

    private static final MessageResolver MESSAGE_RESOLVER = new SimpleMessageResolver();
    private static final String ERROR_DOMAIN_ERROR = "error.domain-error";
    private static final Object[] EMPTY_DATA = {};
    private final String code;
    private final Object[] data;

    public DomainException() {
        this.code = ERROR_DOMAIN_ERROR;
        this.data = EMPTY_DATA;
    }

    public DomainException(String code, Object... data) {
        super(MESSAGE_RESOLVER.resolve(code, data));
        this.code = code;
        this.data = data;
    }

    public DomainException(Throwable cause) {
        super(cause);
        this.code = ERROR_DOMAIN_ERROR;
        this.data = EMPTY_DATA;
    }

    public DomainException(String code, Throwable cause, Object... data) {
        super(MESSAGE_RESOLVER.resolve(code, data), cause);
        this.code = code;
        this.data = data;
    }

    public String format(MessageResolver resolver) {
        return resolver.resolve(code, data);
    }

    public List<Object> data() {
        return List.of(data);
    }

}

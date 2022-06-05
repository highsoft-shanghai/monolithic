package ltd.highsoft.frameworks.domain.core;

import java.util.List;

import static ltd.highsoft.frameworks.domain.core.I18nMessage.message;

public class DomainException extends RuntimeException {

    private static final MessageResolver MESSAGE_RESOLVER = new SimpleMessageResolver();
    private static final String ERROR_DOMAIN_ERROR = "error.domain-error";
    private static final Object[] EMPTY_DATA = {};
    private final I18nMessage message;
    private final String code;
    private final Object[] data;

    public DomainException() {
        this.message = message(ERROR_DOMAIN_ERROR);
        this.code = ERROR_DOMAIN_ERROR;
        this.data = EMPTY_DATA;
    }

    public DomainException(String code, Object... data) {
        this.message = message(code, data);
        this.code = code;
        this.data = data;
    }

    public DomainException(Throwable cause) {
        super(cause);
        this.message = message(ERROR_DOMAIN_ERROR);
        this.code = ERROR_DOMAIN_ERROR;
        this.data = EMPTY_DATA;
    }

    public DomainException(String code, Throwable cause, Object... data) {
        super(cause);
        this.message = message(code, data);
        this.code = code;
        this.data = data;
    }

    @Override
    public String getMessage() {
        return message.format(MESSAGE_RESOLVER);
    }

    public String format(MessageResolver resolver) {
        return message.format(resolver);
    }

    public List<Object> data() {
        return List.of(data);
    }

}

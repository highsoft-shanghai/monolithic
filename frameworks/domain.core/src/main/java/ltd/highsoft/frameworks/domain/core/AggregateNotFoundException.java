package ltd.highsoft.frameworks.domain.core;

public class AggregateNotFoundException extends DomainException {

    public static final String MESSAGE_CODE = "error.aggregate-not-found";

    public AggregateNotFoundException(Object... data) {
        super(MESSAGE_CODE, data);
    }

    public AggregateNotFoundException(Throwable cause, Object... data) {
        super(MESSAGE_CODE, cause, data);
    }

}

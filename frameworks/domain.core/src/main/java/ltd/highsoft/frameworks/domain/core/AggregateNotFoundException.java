package ltd.highsoft.frameworks.domain.core;

public class AggregateNotFoundException extends DomainException {

    public AggregateNotFoundException(String code, Object... data) {
        super(code, data);
    }

    public AggregateNotFoundException(String code, Throwable cause, Object... data) {
        super(code, cause, data);
    }

}

package ltd.highsoft.frameworks.domain.core;

public class AggregateNotFoundException extends DomainException {

    public AggregateNotFoundException(String code, Object... data) {
        super(code, data);
    }

}

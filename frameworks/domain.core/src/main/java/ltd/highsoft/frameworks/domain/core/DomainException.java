package ltd.highsoft.frameworks.domain.core;

public class DomainException extends RuntimeException {

    public DomainException() {
    }

    public DomainException(String code) {
        super(code);
    }

    public String format(MessageResolver resolver) {
        return resolver.resolve(getMessage());
    }

}

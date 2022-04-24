package ltd.highsoft.frameworks.domain.core;

import java.util.Locale;

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

    public String format(MessageResolver resolver, Locale locale) {
        return resolver.resolve(getMessage(), locale, data);
    }

}

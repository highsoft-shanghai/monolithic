package ltd.highsoft.frameworks.application.core;

import ltd.highsoft.frameworks.domain.core.DomainException;
import ltd.highsoft.frameworks.domain.core.MessageResolver;

public class ApplicationException extends RuntimeException {

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }

    public String format(MessageResolver messageResolver) {
        if (getCause() instanceof DomainException) return ((DomainException)getCause()).format(messageResolver);
        return messageResolver.resolve(getMessage());
    }

}

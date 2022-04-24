package ltd.highsoft.frameworks.application.core;

import ltd.highsoft.frameworks.domain.core.MessageResolver;

public class ApplicationException extends RuntimeException {

    public ApplicationException(String message) {
        super(message);
    }

    public String format(MessageResolver messageResolver) {
        return messageResolver.resolve(getMessage());
    }

}

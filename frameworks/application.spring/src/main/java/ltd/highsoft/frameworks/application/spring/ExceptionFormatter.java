package ltd.highsoft.frameworks.application.spring;

import ltd.highsoft.frameworks.domain.core.*;

public class ExceptionFormatter {

    private final MessageResolver messageResolver;

    public ExceptionFormatter(MessageResolver messageResolver) {
        this.messageResolver = messageResolver;
    }

    public String format(Throwable throwable) {
        if (!(throwable instanceof DomainException)) return messageResolver.resolve(throwable.getMessage());
        return ((DomainException) throwable).format(messageResolver);
    }

}

package ltd.highsoft.frameworks.application.spring;

import ltd.highsoft.frameworks.application.core.ApplicationException;
import ltd.highsoft.frameworks.domain.core.MessageResolver;

public class ExceptionFormatter {

    private final MessageResolver messageResolver;

    public ExceptionFormatter(MessageResolver messageResolver) {
        this.messageResolver = messageResolver;
    }

    public String format(Throwable throwable) {
        if (!(throwable instanceof ApplicationException)) return messageResolver.resolve(throwable.getMessage());
        return ((ApplicationException) throwable).format(messageResolver);
    }

}

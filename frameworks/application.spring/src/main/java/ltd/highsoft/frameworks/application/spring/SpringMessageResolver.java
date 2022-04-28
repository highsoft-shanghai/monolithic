package ltd.highsoft.frameworks.application.spring;

import ltd.highsoft.frameworks.domain.core.MessageResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Objects;

public class SpringMessageResolver implements MessageResolver {

    private final MessageSource messageSource;

    public SpringMessageResolver(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public String resolve(String code, Object... args) {
        // TODO: To get locale from context
        return Objects.requireNonNull(messageSource.getMessage(code, args, code, LocaleContextHolder.getLocale()));
    }

}

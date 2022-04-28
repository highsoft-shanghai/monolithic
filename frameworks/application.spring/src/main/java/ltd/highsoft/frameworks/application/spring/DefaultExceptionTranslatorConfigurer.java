package ltd.highsoft.frameworks.application.spring;

import ltd.highsoft.frameworks.domain.core.AggregateNotFoundException;
import ltd.highsoft.frameworks.security.core.*;
import org.springframework.stereotype.Component;

@Component
public class DefaultExceptionTranslatorConfigurer implements ExceptionTranslatorConfigurer {

    @Override
    public void config(ExceptionTranslator translator) {
        translator.map(AggregateNotFoundException.class, Http404Exception::new);
        translator.map(AuthenticationException.class, Http401Exception::new);
        translator.map(AuthorizationException.class, Http403Exception::new);
        translator.map(IllegalArgumentException.class, Http400Exception::new);
    }

}

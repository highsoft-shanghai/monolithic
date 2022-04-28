package ltd.highsoft.frameworks.application.spring;

import ltd.highsoft.frameworks.domain.core.AggregateNotFoundException;
import ltd.highsoft.frameworks.security.core.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;

import java.util.Optional;

@Configuration
@EnableConfigurationProperties
@ComponentScan(basePackageClasses = ApplicationSpringConfiguration.class)
public class ApplicationSpringConfiguration {

    @Bean
    public ExceptionTranslator exceptionTranslator() {
        ExceptionTranslator translator = new ExceptionTranslator();
        translator.map(AggregateNotFoundException.class, Http404Exception::new);
        translator.map(AuthenticationException.class, Http401Exception::new);
        translator.map(AuthorizationException.class, Http403Exception::new);
        translator.map(IllegalArgumentException.class, Http400Exception::new);
        return translator;
    }

    @Bean
    public ExceptionFormatter exceptionFormatter(MessageSource messageSource) {
        return new ExceptionFormatter(new SpringMessageResolver(messageSource));
    }

    @Bean
    public ErrorAttributes errorAttributes() {
        return new ApplicationErrorAttributes();
    }

    @Bean
    public ContextLoader contextLoader() {
        return new ContextLoader(id -> Optional.empty()); // TODO: implement it
    }

}

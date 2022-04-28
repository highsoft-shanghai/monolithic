package ltd.highsoft.frameworks.application.spring;

import ltd.highsoft.frameworks.domain.core.AggregateNotFoundException;
import ltd.highsoft.frameworks.security.core.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
        return translator;
    }

    @Bean
    public ContextLoader contextLoader() {
        return new ContextLoader(id -> Optional.empty()); // TODO: implement it
    }

}

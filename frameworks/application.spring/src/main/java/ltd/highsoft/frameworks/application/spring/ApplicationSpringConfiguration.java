package ltd.highsoft.frameworks.application.spring;

import ltd.highsoft.frameworks.domain.core.AggregateNotFoundException;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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

}

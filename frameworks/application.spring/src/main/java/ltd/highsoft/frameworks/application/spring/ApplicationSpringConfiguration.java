package ltd.highsoft.frameworks.application.spring;

import ltd.highsoft.frameworks.security.core.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;

import java.util.List;

@Configuration
@EnableConfigurationProperties
@ComponentScan(basePackageClasses = ApplicationSpringConfiguration.class)
public class ApplicationSpringConfiguration {

    @Bean
    public ExceptionTranslator exceptionTranslator(List<ExceptionTranslatorConfigurer> configurers) {
        var translator = new ExceptionTranslator();
        configurers.forEach(configure -> configure.config(translator));
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
    public ContextLoader contextLoader(ContextProvider contextProvider) {
        return new ContextLoader(contextProvider);
    }

}

package ltd.highsoft.frameworks.test.web;

import ltd.highsoft.frameworks.security.core.ContextProvider;
import org.springframework.context.annotation.*;

import javax.annotation.Resource;

@Configuration
public class TestWebConfiguration {

    private @Resource ContextProvider contextProvider;

    @Bean
    @Primary
    public ContextProvider testContextProvider() {
        return new WithTestAuthoritiesContextProvider(contextProvider);
    }

}

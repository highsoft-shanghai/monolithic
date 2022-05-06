package ltd.highsoft.monolithic.test.config;

import ltd.highsoft.frameworks.test.web.TestWebConfiguration;
import org.springframework.context.annotation.*;

@Configuration
@Import(TestWebConfiguration.class)
public class TestConfiguration {
}

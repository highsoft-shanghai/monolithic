package ltd.highsoft.monolithic;

import ltd.highsoft.frameworks.test.web.WithTestContainers;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@SpringBootTest
@WithTestContainers(containers = {PostgresContainer.class})
public @interface IntegrationTest {
}

package ltd.highsoft.monolithic;

import ltd.highsoft.frameworks.test.container.WithTestContainers;
import ltd.highsoft.frameworks.test.mongo.MongoContainer;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WithTestContainers(containers = {PostgresContainer.class, MongoContainer.class})
public @interface IntegrationTest {
}

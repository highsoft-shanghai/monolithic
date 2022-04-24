package ltd.highsoft.monolithic;

import ltd.highsoft.frameworks.test.container.WithTestContainers;
import ltd.highsoft.frameworks.test.mongo.MongoContainer;
import ltd.highsoft.frameworks.test.postgres.PostgresContainer;
import ltd.highsoft.frameworks.test.web.RestTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WithTestContainers(containers = {PostgresContainer.class, MongoContainer.class})
public abstract class IntegrationTest extends RestTest {
}

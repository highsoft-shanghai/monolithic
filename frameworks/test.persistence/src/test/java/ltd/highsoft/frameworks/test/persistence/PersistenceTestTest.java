package ltd.highsoft.frameworks.test.persistence;

import ltd.highsoft.frameworks.test.container.WithTestContainers;
import ltd.highsoft.frameworks.test.mongo.MongoContainer;
import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@WithTestContainers(containers = MongoContainer.class)
@PersistenceTest
public class PersistenceTestTest {

    private @Persistence MongoTemplate mongoTemplate;

    @Test
    void should_be_able_to_run_test_with_persistence_ability() {
        assertNotNull(mongoTemplate);
    }

}

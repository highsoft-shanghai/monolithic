package ltd.highsoft.frameworks.test.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import ltd.highsoft.frameworks.test.container.WithTestContainers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.data.mongodb.core.MongoTemplate;

@WithTestContainers(containers = MongoContainer.class)
public abstract class MongoTest {

    private MongoClient mongoClient;
    private MongoTemplate mongoTemplate;

    public MongoTemplate mongoTemplate() {
        return mongoTemplate;
    }

    private MongoClient mongoClient() {
        return mongoClient;
    }

    private String databaseName() {
        return "test";
    }

    @BeforeEach
    void setupMongoClient() {
        mongoClient = MongoClients.create(System.getProperty("spring.data.mongodb.uri"));
        mongoTemplate = new MongoTemplate(mongoClient(), databaseName());
    }

    @AfterEach
    void tearDownMongoClient() {
        mongoClient.close();
    }

}

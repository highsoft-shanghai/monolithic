package ltd.highsoft.frameworks.test.mongo;

import com.mongodb.client.*;
import ltd.highsoft.frameworks.test.container.WithTestContainers;
import org.junit.jupiter.api.*;

@WithTestContainers(containers = MongoContainer.class)
public abstract class MongoTest {

    private MongoClient mongoClient;

    public MongoClient mongoClient() {
        return mongoClient;
    }

    public String databaseName() {
        return "test";
    }

    @BeforeEach
    void setupMongoClient() {
        mongoClient = MongoClients.create(System.getProperty("spring.data.mongodb.uri"));
    }

    @AfterEach
    void tearDownMongoClient() {
        mongoClient.close();
    }

}

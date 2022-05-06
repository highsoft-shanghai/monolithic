package ltd.highsoft.frameworks.test.mongo;

import com.mongodb.client.*;
import ltd.highsoft.frameworks.test.container.WithTestContainers;
import org.bson.Document;
import org.junit.jupiter.api.*;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@WithTestContainers(containers = MongoContainer.class)
class MongoContainerTest {

    private MongoClient mongoClient;
    private MongoCollection<Document> collection;

    @BeforeEach
    void setUp() {
        mongoClient = MongoClients.create(System.getProperty("spring.data.mongodb.uri"));
        var database = mongoClient.getDatabase("test");
        collection = database.getCollection("test");
    }

    @Test
    void should_launch_mongodb_test_container() {
        collection.insertOne(new Document(Map.of("_id", "test.mongo", "name", "John")));
        var cursor = collection.find().cursor();
        assertThat(cursor).isNotNull();
        assertThat(cursor.hasNext()).isTrue();
        assertThat(cursor.next()).isEqualTo(new Document(Map.of("_id", "test.mongo", "name", "John")));
        assertThat(cursor.hasNext()).isFalse();
    }

    @AfterEach
    void tearDown() {
        collection.drop();
        mongoClient.close();
    }

}

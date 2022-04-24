package ltd.highsoft.frameworks.test.mongo;

import ltd.highsoft.frameworks.test.container.TestContainer;
import org.testcontainers.containers.MongoDBContainer;

public class MongoContainer extends TestContainer<MongoDBContainer> {

    @Override
    protected MongoDBContainer createContainer() {
        return new MongoDBContainer("mongo:4.4.10");
    }

    @Override
    protected void setupEnvironment() {
        System.setProperty("spring.data.mongodb.uri", container().getReplicaSetUrl());
    }

}

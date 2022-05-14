package ltd.highsoft.frameworks.test.persistence;

import ltd.highsoft.frameworks.test.container.Containers;
import org.junit.jupiter.api.extension.*;

import java.util.List;

public class PersistenceExtension implements BeforeEachCallback, BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        new Containers<>(context, PersistenceTest.class, PersistenceTest::containers).startContainer();
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        List<Object> instances = context.getRequiredTestInstances().getAllInstances();
        new Instances(instances).autoAssignPersistence();
    }

}

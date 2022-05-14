package ltd.highsoft.frameworks.test.persistence;

import org.junit.jupiter.api.extension.*;

import java.util.*;

public class PersistenceExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        List<Object> instances = context.getRequiredTestInstances().getAllInstances();
        new Instances(instances).autoAssignPersistence();
    }

}

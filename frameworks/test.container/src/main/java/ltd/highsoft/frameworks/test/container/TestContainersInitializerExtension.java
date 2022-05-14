package ltd.highsoft.frameworks.test.container;

import org.junit.jupiter.api.extension.*;

public class TestContainersInitializerExtension implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        new Containers().startContainer(context, WithTestContainers.class, WithTestContainers::containers);
    }

}

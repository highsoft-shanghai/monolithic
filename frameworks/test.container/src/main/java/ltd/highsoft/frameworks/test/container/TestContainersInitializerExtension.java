package ltd.highsoft.frameworks.test.container;

import org.junit.jupiter.api.extension.*;
import org.junit.platform.commons.util.*;
import org.testcontainers.shaded.org.apache.commons.lang3.ArrayUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TestContainersInitializerExtension implements BeforeAllCallback {

    private static final Map<Class<?>, TestContainer<?>> CONTAINERS = new ConcurrentHashMap<>();

    @Override
    public void beforeAll(ExtensionContext context) {
        var annotation = AnnotationUtils.findAnnotation(context.getRequiredTestClass(), WithTestContainers.class);
        var containerClasses = List.of(annotation.map(WithTestContainers::containers).orElse(ArrayUtils.EMPTY_CLASS_ARRAY));
        var newContainerClasses = containerClasses.stream().filter(x -> !CONTAINERS.containsKey(x));
        newContainerClasses.parallel().forEach(this::startContainer);
    }

    private void startContainer(Class<?> containerClass) {
        var container = (TestContainer<?>) ReflectionUtils.newInstance(containerClass);
        container.start();
        CONTAINERS.put(containerClass, container);
    }

}

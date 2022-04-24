package ltd.highsoft.frameworks.test.container;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.util.AnnotationUtils;
import org.junit.platform.commons.util.ReflectionUtils;
import org.testcontainers.shaded.org.apache.commons.lang3.ArrayUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class TestContainersInitializerExtension implements BeforeAllCallback {

    private static final Map<Class<?>, TestContainer<?>> CONTAINERS = new ConcurrentHashMap<>();

    @Override
    public void beforeAll(ExtensionContext context) {
        Optional<WithTestContainers> annotation = AnnotationUtils.findAnnotation(context.getRequiredTestClass(), WithTestContainers.class);
        List<Class<?>> containerClasses = List.of(annotation.map(WithTestContainers::containers).orElse(ArrayUtils.EMPTY_CLASS_ARRAY));
        Stream<Class<?>> newContainerClasses = containerClasses.stream().filter(x -> !CONTAINERS.containsKey(x));
        newContainerClasses.parallel().forEach(this::startContainer);
    }

    private void startContainer(Class<?> containerClass) {
        TestContainer<?> container = (TestContainer<?>) ReflectionUtils.newInstance(containerClass);
        container.start();
        CONTAINERS.put(containerClass, container);
    }

}

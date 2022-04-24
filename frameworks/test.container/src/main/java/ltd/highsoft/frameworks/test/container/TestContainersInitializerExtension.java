package ltd.highsoft.frameworks.test.container;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.util.AnnotationUtils;
import org.junit.platform.commons.util.ReflectionUtils;
import org.testcontainers.shaded.org.apache.commons.lang3.ArrayUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestContainersInitializerExtension implements BeforeAllCallback {

    private static List<TestContainer<?>> containers;

    @Override
    public void beforeAll(ExtensionContext context) {
        if (containers != null) return;
        Optional<WithTestContainers> annotation = AnnotationUtils.findAnnotation(context.getRequiredTestClass(), WithTestContainers.class);
        List<Class<?>> containerClasses = List.of(annotation.map(WithTestContainers::containers).orElse(ArrayUtils.EMPTY_CLASS_ARRAY));
        containers = containerClasses.stream().map(ReflectionUtils::newInstance).map(x -> (TestContainer<?>) x).collect(Collectors.toList());
        containers.stream().parallel().forEach(TestContainer::start);
    }

}

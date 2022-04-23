package ltd.highsoft.monolithic;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.util.AnnotationUtils;
import org.junit.platform.commons.util.ReflectionUtils;
import org.testcontainers.shaded.org.apache.commons.lang3.ArrayUtils;

import java.util.List;
import java.util.Optional;

public class TestContainersInitializerExtension implements BeforeAllCallback {

    private static List<Class<?>> containerClasses;

    @Override
    public void beforeAll(ExtensionContext context) {
        if (containerClasses != null) return;
        Optional<AbstractIntegrationTest> annotation = AnnotationUtils.findAnnotation(context.getRequiredTestClass(), AbstractIntegrationTest.class);
        containerClasses = List.of(annotation.map(AbstractIntegrationTest::containers).orElse(ArrayUtils.EMPTY_CLASS_ARRAY));
        containerClasses.forEach(ReflectionUtils::newInstance);
    }

}

package ltd.highsoft.frameworks.test.context;

import ltd.highsoft.frameworks.domain.core.*;
import org.junit.jupiter.api.extension.*;
import org.junit.platform.commons.util.AnnotationUtils;

public class GlobalIdGeneratorExtension implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        var annotation = AnnotationUtils.findAnnotation(context.getRequiredTestClass(), WithId.class);
        annotation.ifPresent(x -> GlobalIdGeneratorResetter.reset(new FixedIdGenerator(x.value())));
    }

    @Override
    public void afterEach(ExtensionContext context) {
        GlobalIdGeneratorResetter.reset(new UuidBasedIdGenerator());
    }

}

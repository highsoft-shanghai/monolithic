package ltd.highsoft.frameworks.test.context;

import ltd.highsoft.frameworks.domain.core.*;
import org.junit.jupiter.api.extension.*;
import org.junit.platform.commons.util.AnnotationUtils;

import java.util.Optional;

public class GlobalIdGeneratorExtension implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        Optional<WithFixedGlobalIdGenerator> annotation = AnnotationUtils.findAnnotation(context.getRequiredTestClass(), WithFixedGlobalIdGenerator.class);
        annotation.ifPresent(x -> GlobalIdGeneratorResetter.reset(new FixedIdGenerator(x.value())));
    }

    @Override
    public void afterEach(ExtensionContext context) {
        GlobalIdGeneratorResetter.reset(new UuidBasedIdGenerator());
    }

}

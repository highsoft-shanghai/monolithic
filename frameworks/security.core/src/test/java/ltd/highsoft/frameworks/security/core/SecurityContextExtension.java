package ltd.highsoft.frameworks.security.core;

import org.junit.jupiter.api.extension.*;
import org.junit.platform.commons.util.AnnotationUtils;

import java.util.Optional;

public class SecurityContextExtension implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        Optional<WithSecurityContext> annotation = AnnotationUtils.findAnnotation(context.getRequiredTestClass(), WithSecurityContext.class);
        annotation.ifPresent(x -> GlobalSecurityContextResetter.reset(new SimpleSecurityContext(GrantedAuthorities.of(x.grantedAuthorities()))));
    }

    @Override
    public void afterEach(ExtensionContext context) {
        GlobalSecurityContextResetter.clear();
    }

}

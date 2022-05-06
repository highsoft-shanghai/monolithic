package ltd.highsoft.frameworks.test.context;

import ltd.highsoft.frameworks.security.core.*;
import org.junit.jupiter.api.extension.*;
import org.junit.platform.commons.util.AnnotationUtils;

public class SecurityContextExtension implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        var annotation = AnnotationUtils.findAnnotation(context.getRequiredTestClass(), WithSecurityContext.class);
        annotation.ifPresent(x -> GlobalSecurityContextResetter.reset(new SimpleSecurityContext("simple", GrantedAuthorities.of(x.grantedAuthorities()))));
    }

    @Override
    public void afterEach(ExtensionContext context) {
        GlobalSecurityContextResetter.clear();
    }

}

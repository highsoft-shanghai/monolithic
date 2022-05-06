package ltd.highsoft.frameworks.test.web;

import ltd.highsoft.frameworks.security.core.GrantedAuthorities;
import org.junit.jupiter.api.extension.*;
import org.junit.platform.commons.util.AnnotationUtils;

public class WithGrantedAuthoritiesExtension implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        var annotation = AnnotationUtils.findAnnotation(context.getRequiredTestClass(), WithGrantedAuthorities.class);
        annotation.ifPresent(x -> GlobalTestContext.grantedAuthorities(GrantedAuthorities.of(x.value())));
        GlobalTestContext.accessToken(GlobalTestContext.DEFAULT_TESTER_ACCESS_TOKEN);
    }

    @Override
    public void afterEach(ExtensionContext context) {
        GlobalTestContext.grantedAuthorities(null);
        GlobalTestContext.accessToken(null);
    }

}

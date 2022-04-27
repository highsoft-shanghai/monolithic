package ltd.highsoft.frameworks.test.context;

import ltd.highsoft.frameworks.security.core.GrantedAuthorities;
import ltd.highsoft.frameworks.security.core.GrantedDataAuthorities;
import ltd.highsoft.frameworks.security.core.Principal;
import ltd.highsoft.frameworks.security.core.GlobalSecurityContextResetter;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.util.AnnotationUtils;

import java.util.Optional;

public class SecurityContextExtension implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        Optional<WithSecurityContext> annotation = AnnotationUtils.findAnnotation(context.getRequiredTestClass(), WithSecurityContext.class);
        annotation.ifPresent(x -> GlobalSecurityContextResetter.reset(Principal.create(GrantedAuthorities.of(x.grantedAuthorities()), GrantedDataAuthorities.EMPTY)));
    }

    @Override
    public void afterEach(ExtensionContext context) {
        GlobalSecurityContextResetter.clear();
    }

}

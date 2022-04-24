package ltd.highsoft.frameworks.security.core;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.util.AnnotationUtils;

import java.util.Optional;

public class SecurityContextExtension implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        Optional<WithSecurityContext> annotation = AnnotationUtils.findAnnotation(context.getRequiredTestClass(), WithSecurityContext.class);
        annotation.ifPresent(x -> SecurityContextResetter.reset(Principal.create(GrantedAuthorities.of(x.grantedAuthorities()), GrantedDataAuthorities.EMPTY)));
    }

    @Override
    public void afterEach(ExtensionContext context) {
        SecurityContextResetter.reset();
    }

}

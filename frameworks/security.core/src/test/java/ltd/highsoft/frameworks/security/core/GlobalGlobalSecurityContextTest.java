package ltd.highsoft.frameworks.security.core;

import ltd.highsoft.frameworks.domain.core.Testing;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@WithSecurityContext(grantedAuthorities = {"f1", "f2"})
public class GlobalGlobalSecurityContextTest {

    @Test
    void should_be_able_to_reset_security_context() {
        assertThat(Testing.by(GlobalSecurityContext.securityContext().grantedAuthorities()).<Set<String>>get("authorities"))
            .containsExactlyInAnyOrder("f1", "f2");
    }

    @Test
    void should_be_able_to_reset_to_defaults() {
        GlobalSecurityContextResetter.clear();
        assertThat(GlobalSecurityContext.securityContext()).isEqualTo(SecurityContext.ANONYMOUS);
    }

}

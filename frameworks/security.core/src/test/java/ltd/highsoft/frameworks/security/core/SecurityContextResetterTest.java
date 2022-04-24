package ltd.highsoft.frameworks.security.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@WithSecurityContext(grantedAuthorities = {"f1", "f2"})
public class SecurityContextResetterTest {

    @Test
    void should_be_able_to_reset_security_context() {
        assertThat(SecurityContext.principal().grantedAuthorities().asSet()).containsExactlyInAnyOrder("f1", "f2");
    }

    @Test
    void should_be_able_to_reset_to_defaults() {
        SecurityContextResetter.reset();
        assertThat(SecurityContext.principal()).isEqualTo(Principal.ANONYMOUS);
    }

}

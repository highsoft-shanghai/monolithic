package ltd.highsoft.frameworks.security.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@WithSecurityContext(grantedAuthorities = {"f1", "f2"})
public class GlobalGlobalSecurityContextResetterTest {

    @Test
    void should_be_able_to_reset_security_context() {
        assertThat(GlobalSecurityContext.principal().grantedAuthorities().asSet()).containsExactlyInAnyOrder("f1", "f2");
    }

    @Test
    void should_be_able_to_reset_to_defaults() {
        GlobalSecurityContextResetter.clear();
        assertThat(GlobalSecurityContext.principal()).isEqualTo(Principal.ANONYMOUS);
    }

}

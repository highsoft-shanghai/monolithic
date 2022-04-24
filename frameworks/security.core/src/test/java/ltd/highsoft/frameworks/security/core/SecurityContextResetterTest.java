package ltd.highsoft.frameworks.security.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SecurityContextResetterTest {

    @Test
    void should_be_able_to_reset_security_context() {
        Principal principal = Principal.create(GrantedAuthorities.EMPTY, GrantedDataAuthorities.EMPTY);
        SecurityContextResetter.reset(principal);
        assertThat(SecurityContext.principal()).isEqualTo(principal);
    }

    @Test
    void should_be_able_to_reset_to_defaults() {
        Principal principal = Principal.create(GrantedAuthorities.EMPTY, GrantedDataAuthorities.EMPTY);
        SecurityContextResetter.reset(principal);
        SecurityContextResetter.reset();
        assertThat(SecurityContext.principal()).isEqualTo(Principal.ANONYMOUS);
    }

}

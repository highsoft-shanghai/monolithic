package ltd.highsoft.frameworks.security.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SecurityContextTest {

    @Test
    void should_be_able_to_represent_anonymous() {
        assertThat(SecurityContext.ANONYMOUS.token()).isEqualTo("anonymous");
        assertThat(SecurityContext.ANONYMOUS.grantedAuthorities()).isEqualTo(GrantedAuthorities.ANONYMOUS);
    }

}

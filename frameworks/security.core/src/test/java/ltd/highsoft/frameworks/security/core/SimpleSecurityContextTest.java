package ltd.highsoft.frameworks.security.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SimpleSecurityContextTest {

    @Test
    void should_be_able_to_hold_granted_authorities() {
        SimpleSecurityContext context = new SimpleSecurityContext(GrantedAuthorities.ANONYMOUS);
        assertThat(context.grantedAuthorities()).isEqualTo(GrantedAuthorities.ANONYMOUS);
        assertThat(context.token()).isEqualTo("simple");
    }

    @Test
    void should_delegate_authorization_to_underlying_granted_authorities() {
        SimpleSecurityContext context = new SimpleSecurityContext(GrantedAuthorities.ANONYMOUS);
        assertThatThrownBy(() -> context.authorize(RequiredAuthorities.AUTHENTICATED)).isInstanceOf(AuthenticationException.class);
    }

}

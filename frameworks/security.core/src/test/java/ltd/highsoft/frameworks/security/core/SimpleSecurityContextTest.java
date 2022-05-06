package ltd.highsoft.frameworks.security.core;

import ltd.highsoft.frameworks.domain.core.AuthenticationException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SimpleSecurityContextTest {

    @Test
    void should_answer_yes_when_test_for_validity() {
        assertThat(new SimpleSecurityContext("simple", GrantedAuthorities.ANONYMOUS).valid()).isTrue();
    }

    @Test
    void should_be_able_to_hold_granted_authorities() {
        var context = new SimpleSecurityContext("simple", GrantedAuthorities.ANONYMOUS);
        assertThat(context.token()).isEqualTo("simple");
        assertThat(context.grantedAuthorities()).isEqualTo(GrantedAuthorities.ANONYMOUS);
    }

    @Test
    void should_delegate_authorization_to_underlying_granted_authorities() {
        var context = new SimpleSecurityContext("simple", GrantedAuthorities.ANONYMOUS);
        assertThatThrownBy(() -> context.authorize(RequiredAuthorities.AUTHENTICATED)).isInstanceOf(AuthenticationException.class);
    }

}

package ltd.highsoft.frameworks.security.core;

import ltd.highsoft.frameworks.domain.core.*;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class GrantedAuthoritiesTest {

    @Test
    void should_be_able_to_hold_authorities() {
        assertThat(Testing.by(GrantedAuthorities.of("f1", "f2")).<Set<String>>get("authorities")).isEqualTo(Set.of("f1", "f2"));
        assertThat(Testing.by(GrantedAuthorities.of(Set.of("f1", "f2"))).<Set<String>>get("authorities")).isEqualTo(Set.of("f1", "f2"));
    }

    @Test
    void should_allow_authorized_accesses() {
        assertDoesNotThrow(() -> GrantedAuthorities.of("f1", "f2").authorize(RequiredAuthorities.of("f2")));
        assertDoesNotThrow(() -> GrantedAuthorities.of("f1", "f2").authorize(RequiredAuthorities.of("f1")));
    }

    @Test
    void should_deny_unauthorized_accesses() {
        var throwable = catchThrowable(() -> GrantedAuthorities.of("f1", "f2").authorize(RequiredAuthorities.of("f3")));
        assertThat(throwable).isInstanceOf(AuthorizationException.class);
        assertThat(throwable).hasMessage("error.access-denied: [RequiredAuthorities(f3), GrantedAuthorities(f1, f2)]");
    }

    @Test
    void should_allow_accesses_which_just_require_anonymous() {
        assertDoesNotThrow(() -> GrantedAuthorities.of("f1", "f2").authorize(RequiredAuthorities.ANONYMOUS));
        assertDoesNotThrow(() -> GrantedAuthorities.of().authorize(RequiredAuthorities.ANONYMOUS));
    }

    @Test
    void should_allow_accesses_which_just_require_authenticated() {
        assertDoesNotThrow(() -> GrantedAuthorities.of("f1", "f2").authorize(RequiredAuthorities.AUTHENTICATED));
    }

    @Test
    void should_allow_any_accesses_when_it_contains_admin_authority() {
        assertDoesNotThrow(() -> GrantedAuthorities.of(Authorities.ADMIN).authorize(RequiredAuthorities.of("any-access")));
    }

    @Test
    void should_allow_any_accesses_when_it_contains_system_authority() {
        assertDoesNotThrow(() -> GrantedAuthorities.of(Authorities.SYSTEM).authorize(RequiredAuthorities.of("any-access")));
    }

    @Test
    void should_deny_accesses_which_require_more_than_anonymous_if_it_is_anonymous() {
        Throwable throwable = catchThrowable(() -> GrantedAuthorities.ANONYMOUS.authorize(RequiredAuthorities.of("f3")));
        assertThat(throwable).isInstanceOf(AuthenticationException.class);
        assertThat(throwable).hasMessage("error.authentication-required");
    }

    @Test
    void should_be_able_to_format_as_simple_string() {
        assertThat(GrantedAuthorities.of("f1", "f2", "f8", "f0").toString()).isEqualTo("GrantedAuthorities(f0, f1, f2, f8)");
    }

}

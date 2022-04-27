package ltd.highsoft.frameworks.security.core;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class GrantedAuthoritiesTest {

    @Test
    void should_be_able_to_hold_authorities() {
        assertThat(GrantedAuthorities.of("f1", "f2").asSet()).isEqualTo(Set.of("f1", "f2"));
        assertThat(GrantedAuthorities.of(Set.of("f1", "f2")).asSet()).isEqualTo(Set.of("f1", "f2"));
    }

    @Test
    void should_allow_authorized_accesses() {
        assertDoesNotThrow(() -> GrantedAuthorities.of("f1", "f2").authorize(RequiredAuthorities.of("f2")));
        assertDoesNotThrow(() -> GrantedAuthorities.of("f1", "f2").authorize(RequiredAuthorities.of("f1")));
    }

    @Test
    void should_deny_unauthorized_accesses() {
        Throwable throwable = catchThrowable(() -> GrantedAuthorities.of("f1", "f2").authorize(RequiredAuthorities.of("f3")));
        assertThat(throwable).isInstanceOf(AuthorizationException.class);
        assertThat(throwable).hasMessage("error.access-denied");
    }

    @Test
    void should_allow_accesses_which_only_require_anonymous() {
        assertDoesNotThrow(() -> GrantedAuthorities.of("f1", "f2").authorize(RequiredAuthorities.ANONYMOUS));
        assertDoesNotThrow(() -> GrantedAuthorities.of().authorize(RequiredAuthorities.ANONYMOUS));
    }

    @Test
    void should_match_authenticated_only_required_authorities() {
        assertThat(GrantedAuthorities.of("f1").match(RequiredAuthorities.AUTHENTICATED)).isTrue();
    }

    @Test
    void should_not_match_authenticated_only_required_authorities_when_it_is_anonymous() {
        assertThat(GrantedAuthorities.ANONYMOUS.match(RequiredAuthorities.AUTHENTICATED)).isFalse();
    }

    @Test
    void should_match_anything_when_it_contains_admin_authority() {
        assertThat(GrantedAuthorities.of(Authorities.ADMIN).match(RequiredAuthorities.of("any"))).isTrue();
    }

    @Test
    void should_match_anything_when_it_contains_system_authority() {
        assertThat(GrantedAuthorities.of(Authorities.SYSTEM).match(RequiredAuthorities.of("any"))).isTrue();
    }

}

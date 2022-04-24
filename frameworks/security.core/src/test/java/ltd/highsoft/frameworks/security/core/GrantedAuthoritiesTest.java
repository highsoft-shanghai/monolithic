package ltd.highsoft.frameworks.security.core;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class GrantedAuthoritiesTest {

    @Test
    void should_be_able_to_hold_authorities() {
        assertThat(GrantedAuthorities.of("f1", "f2").asSet()).isEqualTo(Set.of("f1", "f2"));
        assertThat(GrantedAuthorities.of(Set.of("f1", "f2")).asSet()).isEqualTo(Set.of("f1", "f2"));
    }

    @Test
    void should_match_required_authorities_when_any_of_its_authorities_matched() {
        assertThat(GrantedAuthorities.of("f1", "f2").match(RequiredAuthorities.of("f2"))).isTrue();
        assertThat(GrantedAuthorities.of("f1", "f2").match(RequiredAuthorities.of("f1"))).isTrue();
    }

    @Test
    void should_not_match_required_authorities_when_non_of_authorities_matched() {
        assertThat(GrantedAuthorities.of("f1", "f2").match(RequiredAuthorities.of("f3"))).isFalse();
        assertThat(GrantedAuthorities.of().match(RequiredAuthorities.of("f3"))).isFalse();
    }

    @Test
    void should_match_required_authorities_which_are_anonymous() {
        assertThat(GrantedAuthorities.of("f1").match(RequiredAuthorities.ANONYMOUS)).isTrue();
        assertThat(GrantedAuthorities.of("").match(RequiredAuthorities.ANONYMOUS)).isTrue();
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

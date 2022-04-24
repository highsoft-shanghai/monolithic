package ltd.highsoft.frameworks.security.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class AuthenticatedPrincipalTest {

    private Principal principal;

    @BeforeEach
    void setUp() {
        principal = Principal.create(GrantedAuthorities.of("abc"), GrantedDataAuthorities.EMPTY);
    }

    @Test
    void should_be_able_to_hold_principal_info() {
        assertThat(principal.grantedAuthorities()).isEqualTo(GrantedAuthorities.of("abc"));
        assertThat(principal.grantedDataAuthorities()).isEqualTo(GrantedDataAuthorities.EMPTY);
    }

    @Test
    void should_report_access_denied_if_no_authorities_matched() {
        Throwable throwable = catchThrowable(() -> principal.authorize(RequiredAuthorities.of("ccc")));
        assertThat(throwable).isInstanceOf(AuthorizationException.class);
        assertThat(throwable).hasMessage("error.access-denied");
        assertThat(((AuthorizationException)throwable).requiredAuthorities()).usingRecursiveComparison().isEqualTo(RequiredAuthorities.of("ccc"));
        assertThat(((AuthorizationException)throwable).grantedAuthorities()).usingRecursiveComparison().isEqualTo(GrantedAuthorities.of("abc"));
    }

    @Test
    void should_report_unauthenticated_if_it_is_anonymous() {
        Throwable throwable = catchThrowable(() -> Principal.ANONYMOUS.authorize(RequiredAuthorities.of("ccc")));
        assertThat(throwable).isInstanceOf(AuthenticationException.class);
        assertThat(throwable).hasMessage("error.bad-credential");
    }

}

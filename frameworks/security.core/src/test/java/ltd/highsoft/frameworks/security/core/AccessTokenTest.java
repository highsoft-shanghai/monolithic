package ltd.highsoft.frameworks.security.core;

import ltd.highsoft.frameworks.domain.core.*;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class AccessTokenTest {

    private AccessTokenOwner owner;
    private GrantedAuthorities authorities;

    @BeforeEach
    void setUp() {
        GlobalIdGeneratorResetter.reset(new FixedIdGenerator("fixed-id"));
        owner = new AccessTokenOwner();
        authorities = GrantedAuthorities.of("f1", "f2");
    }

    @Test
    void should_be_able_to_carry_owner_info() {
        assertThat(AccessToken.create(owner, authorities).owner()).isEqualTo(owner);
    }

    @Test
    void should_be_able_to_generate_id() {
        assertThat(AccessToken.create(owner, authorities).id()).isEqualTo("fixed-id");
    }

    @Test
    void should_allow_authorized_accesses() {
        assertDoesNotThrow(() -> AccessToken.create(owner, authorities).authorize(RequiredAuthorities.of("f1")));
    }

    @Test
    void should_deny_unauthorized_access() {
        Throwable throwable = catchThrowable(() -> AccessToken.create(owner, authorities).authorize(RequiredAuthorities.of("unauthorized-id")));
        assertThat(throwable).isInstanceOf(AuthorizationException.class);
        assertThat(throwable).hasMessage("error.access-denied");
    }

}

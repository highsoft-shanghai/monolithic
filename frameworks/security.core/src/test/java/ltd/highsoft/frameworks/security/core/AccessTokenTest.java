package ltd.highsoft.frameworks.security.core;

import ltd.highsoft.frameworks.domain.core.Identity;
import ltd.highsoft.frameworks.test.context.WithFixedGlobalIdGenerator;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

@WithFixedGlobalIdGenerator("fixed-id")
class AccessTokenTest {

    private AccessTokenOwner owner;
    private GrantedAuthorities authorities;

    @BeforeEach
    void setUp() {
        owner = new AccessTokenOwner(new Identity("kite@highsoft", "Kite"), new Identity("kite", "Kite"), new Identity("highsoft", "Highsoft"));
        authorities = GrantedAuthorities.of("f1", "f2");
    }

    @Test
    void should_be_able_to_carry_owner_info() {
        assertThat(AccessToken.create(owner, authorities).owner()).isEqualTo(owner);
    }

    @Test
    void should_be_able_to_carry_granted_authorities() {
        assertThat(AccessToken.create(owner, authorities).grantedAuthorities()).isEqualTo(authorities);
    }

    @Test
    void should_be_able_to_generate_id() {
        assertThat(AccessToken.create(owner, authorities).token()).isEqualTo("fixed-id");
    }

    @Test
    void should_deny_unauthorized_access() {
        assertThatThrownBy(() -> AccessToken.create(owner, authorities).authorize(RequiredAuthorities.of("unauthorized-id"))).isInstanceOf(AuthorizationException.class);
    }

}

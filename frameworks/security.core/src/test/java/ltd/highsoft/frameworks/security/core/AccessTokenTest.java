package ltd.highsoft.frameworks.security.core;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class AccessTokenTest {

    private AccessTokenOwner owner;
    private GrantedAuthorities authorities;

    @BeforeEach
    void setUp() {
        owner = new AccessTokenOwner();
        authorities = GrantedAuthorities.of("f1", "f2");
    }

    @Test
    void should_be_able_to_carry_owner_info() {
        assertThat(AccessToken.create(owner, authorities).owner()).isEqualTo(owner);
    }

    @Test
    void should_be_able_to_generate_id() {
        assertThat(AccessToken.create(owner, authorities).id()).hasSize(32);
    }

    @Test
    void should_be_able_to_authorize_accesses() {
        assertDoesNotThrow(() -> AccessToken.create(owner, authorities).authorize(RequiredAuthorities.of("f1")));
    }

}

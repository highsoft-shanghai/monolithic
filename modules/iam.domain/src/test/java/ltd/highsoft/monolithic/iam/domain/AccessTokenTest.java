package ltd.highsoft.monolithic.iam.domain;

import ltd.highsoft.frameworks.context.core.SimpleUserContext;
import ltd.highsoft.frameworks.domain.core.Identity;
import ltd.highsoft.frameworks.security.core.*;
import ltd.highsoft.frameworks.test.context.WithId;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@WithId("fixed-id")
class AccessTokenTest {

    public static final Identity KITE_AT_HIGHSOFT = new Identity("kite@highsoft", "Kite");
    public static final Identity KITE = new Identity("kite", "Kite");
    public static final Identity HIGHSOFT = new Identity("highsoft", "Highsoft");
    private AccessTokenOwner owner;
    private GrantedAuthorities authorities;

    @BeforeEach
    void setUp() {
        owner = new AccessTokenOwner(KITE_AT_HIGHSOFT, KITE, HIGHSOFT);
        authorities = GrantedAuthorities.of("f1", "f2");
    }

    @Test
    void should_be_able_to_carry_granted_authorities() {
        assertThat(AccessToken.create(owner, authorities).securityContext().grantedAuthorities()).isEqualTo(authorities);
    }

    @Test
    void should_be_able_to_generate_id() {
        assertThat(AccessToken.create(owner, authorities).token()).isEqualTo("fixed-id");
    }

    @Test
    void should_be_able_to_provide_user_context() {
        assertThat(AccessToken.create(owner, authorities).userContext()).isEqualTo(new SimpleUserContext(KITE_AT_HIGHSOFT, KITE, HIGHSOFT));
    }

    @Test
    void should_be_able_to_provide_security_context() {
        assertThat(AccessToken.create(owner, authorities).securityContext()).isEqualTo(new SimpleSecurityContext("fixed-id", authorities));
    }

}

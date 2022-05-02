package ltd.highsoft.frameworks.security.core;

import ltd.highsoft.frameworks.context.core.*;
import ltd.highsoft.frameworks.domain.core.Identity;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@MockitoSettings
class ContextLoaderTest {

    public static final Identity USER_ACCOUNT_OF_TESTER = new Identity("tester@highsoft", "Tester");
    public static final Identity USER_OF_TESTER = new Identity("tester", "Tester");
    public static final Identity TENANT_OF_HIGHSOFT = new Identity("highsoft", "Highsoft");
    public static final AccessTokenOwner ACCESS_TOKEN_OWNER = new AccessTokenOwner(USER_ACCOUNT_OF_TESTER, USER_OF_TESTER, TENANT_OF_HIGHSOFT);
    private static final AccessToken ACCESS_TOKEN = AccessToken.restore("token-id", ACCESS_TOKEN_OWNER, GrantedAuthorities.of("f1", "f2"));
    private @Mock AccessTokenProvider accessTokenProvider;
    private ContextLoader loader;

    @BeforeEach
    void setUp() {
        loader = new ContextLoader(accessTokenProvider);
    }

    @Test
    void should_be_able_to_load_context_from_access_tokens() {
        given(accessTokenProvider.get("token-id")).willReturn(Optional.of(ACCESS_TOKEN));
        loader.load("token-id");
        assertThat(GlobalUserContext.userContext()).isEqualTo(ACCESS_TOKEN_OWNER);
        assertThat(GlobalSecurityContext.principal()).isEqualTo(ACCESS_TOKEN);
    }

    @Test
    void should_load_anonymous_context_when_no_token_id_provided() {
        loader.load("");
        assertThat(GlobalUserContext.userContext()).isEqualTo(UserContext.ANONYMOUS);
        assertThat(GlobalSecurityContext.principal()).isEqualTo(SecurityContext.ANONYMOUS);
    }

    @AfterEach
    void tearDown() {
        loader.clear();
    }

}

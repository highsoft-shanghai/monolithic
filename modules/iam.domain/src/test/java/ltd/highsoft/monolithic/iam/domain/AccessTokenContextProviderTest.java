package ltd.highsoft.monolithic.iam.domain;

import ltd.highsoft.frameworks.domain.core.Identity;
import ltd.highsoft.frameworks.security.core.*;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@MockitoSettings
public class AccessTokenContextProviderTest {

    private static final AccessTokenOwner TOKEN_OWNER = new AccessTokenOwner(new Identity("tester@highsoft.ltd", "Test"), new Identity("tester", "Tester"), new Identity("highsoft", "Highsoft"));
    private static final AccessToken TOKEN_FROM_REPOSITORY = AccessToken.restore("token-id", TOKEN_OWNER, GrantedAuthorities.of("f1"));
    private @Mock AccessTokens accessTokens;

    @BeforeEach
    void setUp() {
        given(accessTokens.getOptional("token-id")).willReturn(Optional.of(TOKEN_FROM_REPOSITORY));
    }

    @Test
    void should_be_able_to_load_accesses_token_from_underling_repository() {
        ContextProvider provider = new AccessTokenContextProvider(accessTokens);
        assertThat(provider.get("token-id")).isEqualTo(Optional.of(TOKEN_FROM_REPOSITORY));
    }

}

package ltd.highsoft.monolithic.iam.gateways;

import ltd.highsoft.frameworks.domain.core.Identity;
import ltd.highsoft.frameworks.security.core.GrantedAuthorities;
import ltd.highsoft.frameworks.test.mongo.MongoTest;
import ltd.highsoft.monolithic.iam.domain.AccessToken;
import ltd.highsoft.monolithic.iam.domain.AccessTokenOwner;
import ltd.highsoft.monolithic.iam.domain.AccessTokens;
import ltd.highsoft.monolithic.iam.gateways.persistence.MongoAccessToken;
import ltd.highsoft.monolithic.iam.gateways.persistence.MongoAccessTokens;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class MongoAccessTokenRepositoryTest extends MongoTest {

    private static final Identity KITE_AT_HIGHSOFT = new Identity("kite@highsoft", "Kite");
    private static final Identity KITE = new Identity("kite", "Kite");
    private static final Identity HIGHSOFT = new Identity("highsoft", "Highsoft");

    @Test
    void should_be_able_to_load_optional_access_tokens() {
        AccessToken accessToken = AccessToken.restore("test-token", new AccessTokenOwner(KITE_AT_HIGHSOFT, KITE, HIGHSOFT), GrantedAuthorities.of("f1", "f2"));
        mongoTemplate().save(new MongoAccessToken(accessToken));
        AccessTokens accessTokens = new MongoAccessTokens(mongoTemplate());
        assertThat(accessTokens.getOptional("test-token")).usingRecursiveComparison().isEqualTo(Optional.of(accessToken));
    }

}

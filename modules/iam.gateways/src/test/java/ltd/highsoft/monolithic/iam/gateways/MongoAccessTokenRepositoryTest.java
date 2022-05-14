package ltd.highsoft.monolithic.iam.gateways;

import ltd.highsoft.frameworks.domain.core.Identity;
import ltd.highsoft.frameworks.security.core.GrantedAuthorities;
import ltd.highsoft.frameworks.test.mongo.MongoContainer;
import ltd.highsoft.frameworks.test.persistence.*;
import ltd.highsoft.monolithic.iam.domain.*;
import ltd.highsoft.monolithic.iam.gateways.persistence.*;
import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@PersistenceTest(containers = MongoContainer.class)
public class MongoAccessTokenRepositoryTest {

    private static final Identity KITE_AT_HIGHSOFT = new Identity("kite@highsoft", "Kite");
    private static final Identity KITE = new Identity("kite", "Kite");
    private static final Identity HIGHSOFT = new Identity("highsoft", "Highsoft");

    private @Persistence MongoTemplate mongoTemplate;

    @Test
    void should_be_able_to_load_optional_access_tokens() {
        AccessToken accessToken = AccessToken.restore("test-token", new AccessTokenOwner(KITE_AT_HIGHSOFT, KITE, HIGHSOFT), GrantedAuthorities.of("f1", "f2"));
        mongoTemplate.save(new MongoAccessToken(accessToken));
        AccessTokenRepository repository = new MongoAccessTokenRepository(mongoTemplate);
        assertThat(repository.optionalAccessTokenFor("test-token")).usingRecursiveComparison().isEqualTo(Optional.of(accessToken));
    }

}

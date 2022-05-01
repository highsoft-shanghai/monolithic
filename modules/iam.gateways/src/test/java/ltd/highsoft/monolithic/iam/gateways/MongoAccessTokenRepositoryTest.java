package ltd.highsoft.monolithic.iam.gateways;

import ltd.highsoft.frameworks.security.core.*;
import ltd.highsoft.frameworks.test.mongo.MongoTest;
import ltd.highsoft.monolithic.iam.domain.AccessTokenRepository;
import ltd.highsoft.monolithic.iam.gateways.persistence.*;
import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class MongoAccessTokenRepositoryTest extends MongoTest {

    @Test
    void should_be_able_to_load_optional_access_tokens() {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient(), databaseName());
        AccessToken accessToken = AccessToken.restore("test-token", AccessTokenOwner.ANONYMOUS, GrantedAuthorities.of("f1", "f2"));
        mongoTemplate.save(new MongoAccessToken(accessToken));
        AccessTokenRepository repository = new MongoAccessTokenRepository(mongoTemplate);
        assertThat(repository.optionalAccessTokenFor("test-token")).usingRecursiveComparison().isEqualTo(Optional.of(accessToken));
    }

}

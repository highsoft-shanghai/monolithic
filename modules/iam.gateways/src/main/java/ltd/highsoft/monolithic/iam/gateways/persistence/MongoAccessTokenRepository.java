package ltd.highsoft.monolithic.iam.gateways.persistence;

import ltd.highsoft.frameworks.persistence.mongo.MongoRepository;
import ltd.highsoft.frameworks.security.core.AccessToken;
import ltd.highsoft.monolithic.iam.domain.AccessTokenRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MongoAccessTokenRepository implements AccessTokenRepository {

    private final MongoRepository<MongoAccessToken, AccessToken> repository;

    public MongoAccessTokenRepository(MongoTemplate mongoTemplate) {
        repository = new MongoRepository<>(mongoTemplate, MongoAccessToken.class, MongoAccessToken::new, MongoAccessToken::asDomain);
    }

    @Override
    public Optional<AccessToken> optionalAccessTokenFor(String id) {
        return repository.getOptional(id);
    }

}

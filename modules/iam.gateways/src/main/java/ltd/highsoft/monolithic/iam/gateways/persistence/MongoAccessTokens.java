package ltd.highsoft.monolithic.iam.gateways.persistence;

import ltd.highsoft.frameworks.persistence.mongo.MongoAggregates;
import ltd.highsoft.monolithic.iam.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MongoAccessTokens implements AccessTokens {

    private final MongoAggregates<MongoAccessToken, AccessToken> aggregates;

    public MongoAccessTokens(MongoTemplate mongoTemplate) {
        aggregates = new MongoAggregates<>(mongoTemplate, MongoAccessToken.class, MongoAccessToken::new, MongoAccessToken::asDomain, AccessToken::verify);
    }

    @Override
    public Optional<AccessToken> optionalAccessTokenFor(String id) {
        return aggregates.getOptional(id);
    }

    @Override
    public void add(AccessToken accessToken) {
        aggregates.add(accessToken);
    }

    @Override
    public void remove(AccessToken accessToken) {
        aggregates.remove(accessToken.token());
    }

}

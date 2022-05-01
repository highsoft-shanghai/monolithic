package ltd.highsoft.monolithic.iam.domain;

import ltd.highsoft.frameworks.security.core.AccessToken;

import java.util.Optional;

public interface AccessTokenRepository {

    Optional<AccessToken> optionalAccessTokenFor(String id);

}

package ltd.highsoft.monolithic.iam.domain;

import java.util.Optional;

public interface AccessTokenRepository {

    Optional<AccessToken> optionalAccessTokenFor(String id);

    void save(AccessToken accessToken);

    void remove(AccessToken accessToken);

}

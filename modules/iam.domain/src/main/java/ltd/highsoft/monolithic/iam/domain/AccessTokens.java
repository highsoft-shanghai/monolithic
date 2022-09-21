package ltd.highsoft.monolithic.iam.domain;

import java.util.Optional;

public interface AccessTokens {

    Optional<AccessToken> optionalAccessTokenFor(String id);

    void add(AccessToken accessToken);

    void remove(AccessToken accessToken);

}

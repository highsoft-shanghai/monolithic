package ltd.highsoft.frameworks.security.core;

import java.util.Optional;

public interface AccessTokenProvider {

    Optional<AccessToken> get(String id);

}

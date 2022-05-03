package ltd.highsoft.monolithic.iam.domain;

import ltd.highsoft.frameworks.security.core.*;

import java.util.Optional;

public class AccessTokenContextProvider implements ContextProvider {

    private final AccessTokenRepository accessTokenRepository;

    public AccessTokenContextProvider(AccessTokenRepository accessTokenRepository) {
        this.accessTokenRepository = accessTokenRepository;
    }

    @Override
    public Optional<Context> get(String id) {
        return accessTokenRepository.optionalAccessTokenFor(id).map(x -> x);
    }

}

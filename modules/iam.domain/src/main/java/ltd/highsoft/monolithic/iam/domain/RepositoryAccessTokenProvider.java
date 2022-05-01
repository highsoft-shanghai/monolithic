package ltd.highsoft.monolithic.iam.domain;

import ltd.highsoft.frameworks.security.core.*;

import java.util.Optional;

public class RepositoryAccessTokenProvider implements AccessTokenProvider {

    private final AccessTokenRepository accessTokenRepository;

    public RepositoryAccessTokenProvider(AccessTokenRepository accessTokenRepository) {
        this.accessTokenRepository = accessTokenRepository;
    }

    @Override
    public Optional<AccessToken> get(String id) {
        return accessTokenRepository.optionalAccessTokenFor(id);
    }

}

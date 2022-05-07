package ltd.highsoft.monolithic.iam.application;

import ltd.highsoft.frameworks.application.core.UseCase;
import ltd.highsoft.frameworks.security.core.Authorities;
import ltd.highsoft.monolithic.iam.domain.*;

import java.util.Optional;

import static ltd.highsoft.frameworks.security.core.GlobalSecurityContext.securityContext;

@UseCase(requiredAuthorities = Authorities.AUTHENTICATED)
public class GetAccessTokenContentUseCase {

    private final AccessTokenRepository accessTokenRepository;

    public GetAccessTokenContentUseCase(AccessTokenRepository accessTokenRepository) {
        this.accessTokenRepository = accessTokenRepository;
    }

    public Optional<AccessToken> execute() {
        return accessTokenRepository.optionalAccessTokenFor(securityContext().token());
    }

}

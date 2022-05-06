package ltd.highsoft.monolithic.iam.application;

import ltd.highsoft.frameworks.application.core.UseCase;
import ltd.highsoft.frameworks.security.core.Authorities;
import ltd.highsoft.monolithic.iam.domain.*;

import static ltd.highsoft.frameworks.security.core.GlobalSecurityContext.securityContext;

@UseCase(requiredAuthorities = Authorities.AUTHENTICATED)
public class GetAccessTokenContentUseCase {

    private final AccessTokenRepository accessTokenRepository;

    public GetAccessTokenContentUseCase(AccessTokenRepository accessTokenRepository) {
        this.accessTokenRepository = accessTokenRepository;
    }

    public AccessToken execute() {
        var accessToken = accessTokenRepository.optionalAccessTokenFor(securityContext().token());
        assert accessToken.isPresent();
        return accessToken.get();
    }

}

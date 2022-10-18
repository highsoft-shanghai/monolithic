package ltd.highsoft.monolithic.iam.application;

import ltd.highsoft.frameworks.application.core.UseCase;
import ltd.highsoft.frameworks.domain.core.ValueSink;
import ltd.highsoft.frameworks.security.core.Authorities;
import ltd.highsoft.monolithic.iam.domain.AccessTokens;

import java.util.Optional;

import static ltd.highsoft.frameworks.domain.core.GlobalValueSinkFactory.createValueSink;
import static ltd.highsoft.frameworks.security.core.GlobalSecurityContext.securityContext;

@UseCase(requiredAuthorities = Authorities.AUTHENTICATED)
public class GetAccessTokenContentUseCase {

    private final AccessTokens accessTokens;

    public GetAccessTokenContentUseCase(AccessTokens accessTokens) {
        this.accessTokens = accessTokens;
    }

    public Optional<ValueSink> execute() {
        var accessToken = accessTokens.getOptional(securityContext().token());
        return accessToken.map(token -> createValueSink(token::content));
    }

}

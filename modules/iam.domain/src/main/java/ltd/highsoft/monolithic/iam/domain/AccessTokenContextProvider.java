package ltd.highsoft.monolithic.iam.domain;

import ltd.highsoft.frameworks.security.core.*;

import java.util.Optional;

public class AccessTokenContextProvider implements ContextProvider {

    private final AccessTokens accessTokens;

    public AccessTokenContextProvider(AccessTokens accessTokens) {
        this.accessTokens = accessTokens;
    }

    @Override
    public Optional<Context> get(String id) {
        return accessTokens.getOptional(id).map(x -> x);
    }

}

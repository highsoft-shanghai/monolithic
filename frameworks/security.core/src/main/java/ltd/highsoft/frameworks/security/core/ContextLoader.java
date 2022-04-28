package ltd.highsoft.frameworks.security.core;

import ltd.highsoft.frameworks.context.core.GlobalUserContextResetter;

public class ContextLoader {

    private final AccessTokenProvider accessTokenProvider;

    public ContextLoader(AccessTokenProvider accessTokenProvider) {
        this.accessTokenProvider = accessTokenProvider;
    }

    public void load(String tokenId) {
        loadFromAccessToken(accessTokenProvider.get(tokenId).orElse(AccessToken.ANONYMOUS));
    }

    private void loadFromAccessToken(AccessToken token) {
        GlobalUserContextResetter.reset(token.owner());
        GlobalSecurityContextResetter.reset(token);
    }

    public void clear() {
        GlobalUserContextResetter.clear();
        GlobalSecurityContextResetter.clear();
    }

}

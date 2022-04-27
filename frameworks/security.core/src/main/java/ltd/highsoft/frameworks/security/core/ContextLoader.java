package ltd.highsoft.frameworks.security.core;

public class ContextLoader {

    private final AccessTokenProvider accessTokenProvider;

    public ContextLoader(AccessTokenProvider accessTokenProvider) {
        this.accessTokenProvider = accessTokenProvider;
    }

    public void load(String tokenId) {
        loadFromAccessToken(accessTokenProvider.get(tokenId).orElse(AccessToken.ANONYMOUS));
    }

    private void loadFromAccessToken(AccessToken token) {
//        GlobalUserContextResetter.reset(token);
//        GlobalSecurityContextResetter.reset(token);
    }

    public void clear() {
//        GlobalUserContextResetter.clear();
//        GlobalSecurityContextResetter.clear();
    }

}

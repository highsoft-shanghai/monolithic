package ltd.highsoft.frameworks.security.core;

public class ContextLoader {

    private final AccessTokenProvider accessTokenProvider;

    public ContextLoader(AccessTokenProvider accessTokenProvider) {
        this.accessTokenProvider = accessTokenProvider;
    }

    public void load(String tokenId) {
        accessTokenProvider.get(tokenId).ifPresentOrElse(this::loadFromAccessToken, this::loadAnonymous);
    }

    private void loadFromAccessToken(AccessToken token) {
//        GlobalUserContextResetter.reset(token);
//        GlobalSecurityContextResetter.reset(token);
    }

    private void loadAnonymous() {
//        GlobalUserContextResetter.reset(UserContext.ANONYMOUS);
//        GlobalSecurityContextResetter.reset(Principal.ANONYMOUS);
    }

    public void clear() {
//        GlobalUserContextResetter.clear();
//        GlobalSecurityContextResetter.clear();
    }

}

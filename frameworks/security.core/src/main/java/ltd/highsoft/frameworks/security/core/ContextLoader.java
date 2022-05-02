package ltd.highsoft.frameworks.security.core;

import ltd.highsoft.frameworks.context.core.GlobalUserContextResetter;
import org.apache.commons.lang3.StringUtils;

public class ContextLoader {

    private final AccessTokenProvider accessTokenProvider;

    public ContextLoader(AccessTokenProvider accessTokenProvider) {
        this.accessTokenProvider = accessTokenProvider;
    }

    public void load(String tokenId) {
        if (StringUtils.isNotBlank(tokenId)) {
            loadFromAccessToken(accessTokenProvider.get(tokenId).orElse(AccessToken.ANONYMOUS));
        } else {
            clear();
        }
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

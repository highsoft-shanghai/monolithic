package ltd.highsoft.monolithic.test.dataset;

import ltd.highsoft.frameworks.domain.core.Identity;
import ltd.highsoft.frameworks.security.core.GrantedAuthorities;
import ltd.highsoft.monolithic.iam.domain.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Tester {

    private final Identity userAccount = new Identity("tester@highsoft", "Tester");
    private final Identity user = new Identity("tester", "Tester");
    private final Identity tenant = new Identity("highsoft", "Highsoft");
    private final AccessTokenOwner accessTokenOwner = new AccessTokenOwner(userAccount, user, tenant);
    private final String accessTokenId = "tester-access-token";
    private final GrantedAuthorities grantedAuthorities = GrantedAuthorities.of("feature-1", "feature-2");
    private final AccessToken accessToken = AccessToken.restore(accessTokenId, accessTokenOwner, grantedAuthorities);
    private @Resource AccessTokens accessTokens;

    public void setup() {
        accessTokens.add(accessToken);
    }

    public void teardown() {
        accessTokens.remove(accessToken);
    }

}

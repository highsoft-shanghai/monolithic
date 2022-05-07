package ltd.highsoft.monolithic.test.dataset;

import ltd.highsoft.frameworks.domain.core.Identity;
import ltd.highsoft.frameworks.security.core.GrantedAuthorities;
import ltd.highsoft.monolithic.iam.domain.*;

public class Tester {

    public static final Identity USER_ACCOUNT = new Identity("tester@highsoft", "Tester");
    public static final Identity USER = new Identity("tester", "Tester");
    public static final Identity TENANT = new Identity("highsoft", "Highsoft");
    public static final AccessTokenOwner ACCESS_TOKEN_OWNER = new AccessTokenOwner(USER_ACCOUNT, USER, TENANT);
    public static final String ACCESS_TOKEN_ID = "tester-access-token";
    public static final GrantedAuthorities GRANTED_AUTHORITIES = GrantedAuthorities.of("feature-1", "feature-2");
    public static final AccessToken ACCESS_TOKEN = AccessToken.restore(ACCESS_TOKEN_ID, ACCESS_TOKEN_OWNER, GRANTED_AUTHORITIES);

}

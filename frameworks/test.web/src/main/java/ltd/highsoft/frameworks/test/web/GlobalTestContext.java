package ltd.highsoft.frameworks.test.web;

import ltd.highsoft.frameworks.security.core.GrantedAuthorities;

import javax.annotation.Nullable;
import java.util.Optional;

public final class GlobalTestContext {

    public static final String DEFAULT_TESTER_ACCESS_TOKEN = "tester-access-token";
    private static final GlobalTestContext INSTANCE = new GlobalTestContext();
    private GrantedAuthorities grantedAuthorities;
    private String accessToken;

    public static Optional<GrantedAuthorities> grantedAuthorities() {
        return Optional.ofNullable(INSTANCE.grantedAuthorities);
    }

    public static void grantedAuthorities(@Nullable GrantedAuthorities grantedAuthorities) {
        INSTANCE.grantedAuthorities = grantedAuthorities;
    }

    public static Optional<String> accessToken() {
        return Optional.ofNullable(INSTANCE.accessToken);
    }

    public static void accessToken(@Nullable String accessToken) {
        INSTANCE.accessToken = accessToken;
    }

}

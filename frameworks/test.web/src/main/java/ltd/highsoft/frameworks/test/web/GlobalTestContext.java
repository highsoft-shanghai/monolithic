package ltd.highsoft.frameworks.test.web;

import ltd.highsoft.frameworks.context.core.SimpleUserContext;
import ltd.highsoft.frameworks.domain.core.Identity;
import ltd.highsoft.frameworks.security.core.*;
import org.assertj.core.util.VisibleForTesting;

import java.util.Optional;

public final class GlobalTestContext {

    private static final GlobalTestContext INSTANCE = new GlobalTestContext();
    private Context context;

    public static Optional<Context> context() {
        return Optional.ofNullable(INSTANCE.context);
    }

    public static Optional<String> token() {
        return context().map(Context::securityContext).map(SecurityContext::token);
    }

    @VisibleForTesting
    static void reset() {
        INSTANCE.context = null;
    }

    public static void setup(GrantedAuthorities grantedAuthorities) {
        INSTANCE.context = new SimpleContext(new SimpleUserContext(userAccount(), user(), tenant()), new SimpleSecurityContext("tester-token-id", grantedAuthorities));
    }

    public static void teardown() {
        INSTANCE.context = Context.ANONYMOUS;
    }

    private static Identity tenant() {
        return new Identity("highsoft", "Highsoft");
    }

    private static Identity user() {
        return new Identity("tester", "Tester");
    }

    private static Identity userAccount() {
        return new Identity("tester@highsoft", "Tester");
    }

}

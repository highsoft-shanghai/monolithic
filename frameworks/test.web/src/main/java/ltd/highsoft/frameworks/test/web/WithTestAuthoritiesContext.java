package ltd.highsoft.frameworks.test.web;

import ltd.highsoft.frameworks.context.core.UserContext;
import ltd.highsoft.frameworks.security.core.*;

public class WithTestAuthoritiesContext implements Context {

    private final Context context;

    public WithTestAuthoritiesContext(Context context) {
        this.context = context;
    }

    @Override
    public UserContext userContext() {
        return context.userContext();
    }

    @Override
    public SecurityContext securityContext() {
        return new WithTestAuthoritiesSecurityContext(context.securityContext());
    }

}

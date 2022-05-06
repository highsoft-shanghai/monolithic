package ltd.highsoft.frameworks.test.web;

import ltd.highsoft.frameworks.security.core.*;

public class WithTestAuthoritiesSecurityContext implements SecurityContext {

    private final SecurityContext context;

    public WithTestAuthoritiesSecurityContext(SecurityContext context) {
        this.context = context;
    }

    @Override
    public String token() {
        return context.token();
    }

    @Override
    public GrantedAuthorities grantedAuthorities() {
        return GlobalTestContext.grantedAuthorities().orElse(context.grantedAuthorities());
    }

    @Override
    public boolean valid() {
        return context.valid();
    }

}

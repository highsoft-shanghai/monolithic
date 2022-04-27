package ltd.highsoft.frameworks.security.core;

public class AuthenticatedPrincipal implements SecurityContext {

    private final GrantedAuthorities grantedAuthorities;

    AuthenticatedPrincipal(GrantedAuthorities authorities) {
        this.grantedAuthorities = authorities;
    }

    @Override
    public void authorize(RequiredAuthorities requiredAuthorities) {
    }

    @Override
    public GrantedAuthorities grantedAuthorities() {
        return grantedAuthorities;
    }

}

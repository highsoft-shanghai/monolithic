package ltd.highsoft.frameworks.security.core;

public class AuthenticatedPrincipal implements Principal {

    private final GrantedAuthorities grantedAuthorities;
    private final GrantedDataAuthorities grantedDataAuthorities;

    AuthenticatedPrincipal(GrantedAuthorities authorities, GrantedDataAuthorities dataAuthorities) {
        this.grantedAuthorities = authorities;
        this.grantedDataAuthorities = dataAuthorities;
    }

    @Override
    public void authorize(RequiredAuthorities requiredAuthorities) {
    }

    @Override
    public GrantedAuthorities grantedAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public GrantedDataAuthorities grantedDataAuthorities() {
        return grantedDataAuthorities;
    }

}

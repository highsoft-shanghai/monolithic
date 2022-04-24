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
        if (grantedAuthorities.match(requiredAuthorities)) return;
        if (grantedAuthorities.isAnonymous()) throw new AuthenticationException("error.bad-credential");
        throw new AuthorizationException("error.access-denied", requiredAuthorities, grantedAuthorities);
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

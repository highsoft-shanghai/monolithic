package ltd.highsoft.frameworks.security.core;

public class SimpleSecurityContext implements SecurityContext {

    private final GrantedAuthorities grantedAuthorities;

    public SimpleSecurityContext(GrantedAuthorities grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
    }

    @Override
    public void authorize(RequiredAuthorities requiredAuthorities) {
        grantedAuthorities.authorize(requiredAuthorities);
    }

    @Override
    public GrantedAuthorities grantedAuthorities() {
        return grantedAuthorities;
    }

}

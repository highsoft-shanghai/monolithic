package ltd.highsoft.frameworks.security.core;

public class SimpleSecurityContext implements SecurityContext {

    private final String token;
    private final GrantedAuthorities grantedAuthorities;

    public SimpleSecurityContext(String simple, GrantedAuthorities grantedAuthorities) {
        this.token = simple;
        this.grantedAuthorities = grantedAuthorities;
    }

    @Override
    public String token() {
        return token;
    }

    @Override
    public GrantedAuthorities grantedAuthorities() {
        return grantedAuthorities;
    }

}

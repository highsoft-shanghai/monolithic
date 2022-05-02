package ltd.highsoft.frameworks.security.core;

public class SimpleSecurityContext implements SecurityContext {

    private final GrantedAuthorities grantedAuthorities;

    public SimpleSecurityContext(GrantedAuthorities grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
    }

    @Override
    public String token() {
        return "simple";
    }

    @Override
    public GrantedAuthorities grantedAuthorities() {
        return grantedAuthorities;
    }

}

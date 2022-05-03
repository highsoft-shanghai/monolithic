package ltd.highsoft.frameworks.security.core;

public class InvalidSecurityContext implements SecurityContext {

    @Override
    public String token() {
        return null;
    }

    @Override
    public GrantedAuthorities grantedAuthorities() {
        return null;
    }

    @Override
    public boolean valid() {
        return false;
    }

}

package ltd.highsoft.frameworks.security.core;

public class InvalidSecurityContext implements SecurityContext {

    @Override
    public String token() {
        throw new AuthenticationException("error.bad-token");
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

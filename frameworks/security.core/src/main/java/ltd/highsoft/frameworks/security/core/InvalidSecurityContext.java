package ltd.highsoft.frameworks.security.core;

import ltd.highsoft.frameworks.domain.core.AuthenticationException;

public class InvalidSecurityContext implements SecurityContext {

    @Override
    public String token() {
        throw new AuthenticationException("error.bad-token");
    }

    @Override
    public GrantedAuthorities grantedAuthorities() {
        throw new AuthenticationException("error.bad-token");
    }

    @Override
    public boolean valid() {
        return false;
    }

}

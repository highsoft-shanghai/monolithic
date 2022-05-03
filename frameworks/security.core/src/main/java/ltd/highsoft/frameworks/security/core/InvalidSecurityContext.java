package ltd.highsoft.frameworks.security.core;

import ltd.highsoft.frameworks.domain.core.BadAccessTokenException;

public class InvalidSecurityContext implements SecurityContext {

    @Override
    public String token() {
        throw new BadAccessTokenException();
    }

    @Override
    public GrantedAuthorities grantedAuthorities() {
        throw new BadAccessTokenException();
    }

    @Override
    public boolean valid() {
        return false;
    }

}

package ltd.highsoft.frameworks.security.core;

import ltd.highsoft.frameworks.domain.core.DomainException;

public class AuthorizationException extends DomainException {

    public AuthorizationException(String code, RequiredAuthorities requiredAuthorities, GrantedAuthorities grantedAuthorities) {
        super(code, requiredAuthorities, grantedAuthorities);
    }

}

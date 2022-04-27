package ltd.highsoft.frameworks.security.core;

import ltd.highsoft.frameworks.domain.core.DomainException;

public class AuthorizationException extends DomainException {

    private final RequiredAuthorities requiredAuthorities;
    private final GrantedAuthorities grantedAuthorities;

    public AuthorizationException(String code, RequiredAuthorities requiredAuthorities, GrantedAuthorities grantedAuthorities) {
        super(code, requiredAuthorities, grantedAuthorities);
        this.requiredAuthorities = requiredAuthorities;
        this.grantedAuthorities = grantedAuthorities;
    }

    public RequiredAuthorities requiredAuthorities() {
        return requiredAuthorities;
    }

    public GrantedAuthorities grantedAuthorities() {
        return grantedAuthorities;
    }

}

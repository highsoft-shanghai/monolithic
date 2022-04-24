package ltd.highsoft.frameworks.security.core;

import ltd.highsoft.frameworks.domain.core.DomainException;

public class AuthenticationException extends DomainException {

    public AuthenticationException(String message) {
        super(message);
    }

}

package ltd.highsoft.frameworks.domain.core;

public class BadAccessTokenException extends AuthenticationException {

    public BadAccessTokenException() {
        super("error.bad-token");
    }

}

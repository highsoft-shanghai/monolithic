package ltd.highsoft.frameworks.application.core;

import ltd.highsoft.frameworks.domain.core.DomainException;

public class ApplicationException extends DomainException {

    public ApplicationException(String code, Throwable cause, Object... data) {
        super(code, cause, data);
    }

    public ApplicationException(String code, Object... data) {
        super(code, data);
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }

}

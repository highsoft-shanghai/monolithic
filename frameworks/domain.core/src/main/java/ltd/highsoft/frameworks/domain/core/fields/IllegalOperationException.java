package ltd.highsoft.frameworks.domain.core.fields;

import ltd.highsoft.frameworks.domain.core.*;

public final class IllegalOperationException extends DomainException {

    public IllegalOperationException(I18nMessage message) {
        super(message);
    }

}

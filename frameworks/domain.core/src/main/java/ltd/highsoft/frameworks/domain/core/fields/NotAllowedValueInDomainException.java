package ltd.highsoft.frameworks.domain.core.fields;

import ltd.highsoft.frameworks.domain.core.*;

public final class NotAllowedValueInDomainException extends DomainException {

    public NotAllowedValueInDomainException(I18nMessage message) {
        super(message);
    }

}

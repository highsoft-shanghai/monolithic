package ltd.highsoft.frameworks.domain.core.fields;

import ltd.highsoft.frameworks.domain.core.*;

public class NotAllowedValueInDomainException extends DomainException {

    public NotAllowedValueInDomainException(I18nMessage message) {
        super(message);
    }

}

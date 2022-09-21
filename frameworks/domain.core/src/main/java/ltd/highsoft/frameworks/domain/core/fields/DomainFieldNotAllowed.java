package ltd.highsoft.frameworks.domain.core.fields;

import java.util.function.Predicate;

import static ltd.highsoft.frameworks.domain.core.I18nMessage.message;

public final class DomainFieldNotAllowed<DomainField> {

    private final Predicate<DomainField> notAllowed;
    private final String errorCode;

    static <DomainFieldType> DomainFieldNotAllowed<DomainFieldType> with(final Predicate<DomainFieldType> notAllowed, final String errorMessage) {
        return new DomainFieldNotAllowed<>(notAllowed, errorMessage);
    }

    void verify(DomainField value) {
        if (!notAllowed.test(value)) {
            return;
        }
        throw new NotAllowedValueInDomainException(message(errorCode, value));
    }

    private DomainFieldNotAllowed(Predicate<DomainField> notAllowed, String errorCode) {
        this.notAllowed = notAllowed;
        this.errorCode = errorCode;
    }

}

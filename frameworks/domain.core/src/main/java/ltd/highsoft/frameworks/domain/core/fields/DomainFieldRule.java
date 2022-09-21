package ltd.highsoft.frameworks.domain.core.fields;

import java.util.Objects;
import java.util.function.Predicate;

import static ltd.highsoft.frameworks.domain.core.I18nMessage.message;

public final class DomainFieldRule<DomainFieldType> {

    private final Predicate<DomainFieldType> rule;

    private final String errorCode;

    public static <DomainFieldType> DomainFieldRule<DomainFieldType> notNull() {
        return with(Objects::nonNull, "error.value-is-null");
    }

    public static DomainFieldRule<String> maxLength(int maxLength) {
        return with(o -> o.length() <= maxLength, "error.value-is-too-large");
    }

    public static <DomainFieldType> DomainFieldRule<DomainFieldType> with(final Predicate<DomainFieldType> notAllowed, final String errorMessage) {
        return new DomainFieldRule<>(notAllowed, errorMessage);
    }

    void verify(DomainFieldType value) {
        if (rule.test(value)) return;
        throw new NotAllowedValueInDomainException(message(errorCode, value));
    }

    private DomainFieldRule(Predicate<DomainFieldType> rule, String errorCode) {
        this.rule = rule;
        this.errorCode = errorCode;
    }

}

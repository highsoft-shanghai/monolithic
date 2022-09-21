package ltd.highsoft.frameworks.domain.core.fields;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.function.Predicate;

import static ltd.highsoft.frameworks.domain.core.I18nMessage.message;

public final class DomainFieldRule<DomainFieldType> {

    private final Predicate<DomainFieldType> rule;

    private final String errorCode;

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

    public static class Anything {

        public static Anything anything() {
            return new Anything();
        }

        public <DomainFieldType> DomainFieldRule<DomainFieldType> notNull() {
            return with(Objects::nonNull, "error.value-is-null");
        }

    }

    public static class StringThing {

        public static StringThing string() {
            return new StringThing();
        }

        public DomainFieldRule<String> maxLength(int maxLength) {
            return with(o -> o.length() <= maxLength, "error.value-is-too-large");
        }

        public DomainFieldRule<String> notEmpty() {
            return with(StringUtils::isNoneBlank, "error.value-is-empty");
        }

        public DomainFieldRule<String> regex(String regex) {
            return with(o -> o.matches(regex), "error.value-do-not-match-regex");
        }

    }

}

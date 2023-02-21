package ltd.highsoft.frameworks.domain.core.fields;

import java.util.Base64;

import static com.google.common.base.Charsets.UTF_8;
import static ltd.highsoft.frameworks.domain.core.I18nMessage.message;
import static ltd.highsoft.frameworks.domain.core.fields.DomainFieldRule.Anything.anything;
import static ltd.highsoft.frameworks.domain.core.fields.DomainFieldRule.StringThing.string;

public final class Password extends DomainField<String> {

    public Password(String value) {
        super(value);
        final int minLength = 8;
        final int maxSize = 100;
        // Must include 3 of [Capitalize English words, Lowercase English words, Number, Special characters] .
        final String passwordRegex = "^(?![a-zA-Z]+$)(?![A-Z0-9]+$)(?![A-Z\\W_]+$)(?![a-z0-9]+$)(?![a-z\\W_]+$)(?![0-9\\W_]+$)[a-zA-Z0-9\\W_]{8,}$";
        addRule(anything().notNull());
        addRule(string().notEmpty());
        addRule(string().minLength(minLength));
        addRule(string().maxLength(maxSize));
        addRule(string().regex(passwordRegex, "error.password-not-match-format"));
        super.verify();
    }

    public EncryptedPassword encrypt() {
        return new EncryptedPassword(this);
    }

    @Override
    public String get() {
        throw new IllegalOperationException(message("error.cannot-get-from-password"));
    }

    String encrypting() {
        return Base64.getEncoder().encodeToString(super.get().getBytes(UTF_8));
    }

}

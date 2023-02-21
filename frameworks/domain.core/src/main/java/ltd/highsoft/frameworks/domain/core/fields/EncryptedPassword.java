package ltd.highsoft.frameworks.domain.core.fields;

import java.util.Objects;

public final class EncryptedPassword {

    private final String value;

    EncryptedPassword(Password password) {
        this.value = password.encrypting();
    }

    public boolean matches(Password password) {
        return Objects.equals(this.value, new EncryptedPassword(password).value);
    }

}

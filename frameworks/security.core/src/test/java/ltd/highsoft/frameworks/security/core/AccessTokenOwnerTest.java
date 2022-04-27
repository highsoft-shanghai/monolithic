package ltd.highsoft.frameworks.security.core;

import ltd.highsoft.frameworks.domain.core.Identity;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccessTokenOwnerTest {

    private final Identity ACCOUNT_OF_JOHN = new Identity("john@highsoft", "John");
    private final Identity JOHN = new Identity("john", "John");

    @Test
    void should_be_able_to_hold_user_account() {
        assertThat(new AccessTokenOwner(ACCOUNT_OF_JOHN, JOHN).userAccount()).isEqualTo(ACCOUNT_OF_JOHN);
    }

    @Test
    void should_be_able_to_hold_user() {
        assertThat(new AccessTokenOwner(ACCOUNT_OF_JOHN, JOHN).user()).isEqualTo(JOHN);
    }

}

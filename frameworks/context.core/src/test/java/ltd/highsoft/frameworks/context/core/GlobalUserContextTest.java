package ltd.highsoft.frameworks.context.core;

import ltd.highsoft.frameworks.domain.core.Identity;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GlobalUserContextTest {

    @Test
    void should_be_able_to_hold_current_user_account() {
        GlobalUserContextResetter.reset(new SimpleUserContext(new Identity("john@highsoft", "John"), new Identity("john", "John"), new Identity("highsoft", "Highsoft")));
        assertThat(GlobalUserContext.currentUserAccount()).isEqualTo(new Identity("john@highsoft", "John"));
    }

}

package ltd.highsoft.frameworks.security.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InvalidSecurityContextTest {

    @Test
    void should_answer_yes() {
        assertThat(new InvalidSecurityContext().valid()).isFalse();
    }

}

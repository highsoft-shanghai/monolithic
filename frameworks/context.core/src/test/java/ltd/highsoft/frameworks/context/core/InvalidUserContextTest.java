package ltd.highsoft.frameworks.context.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InvalidUserContextTest {

    @Test
    void should_answer_no_when_test_for_validity() {
        assertThat(new InvalidUserContext().valid()).isFalse();
    }

}

package ltd.highsoft.frameworks.domain.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DomainExceptionTest {

    @Test
    void should_be_not_checked_exception() {
        assertThat(new DomainException()).isInstanceOf(RuntimeException.class);
    }

}

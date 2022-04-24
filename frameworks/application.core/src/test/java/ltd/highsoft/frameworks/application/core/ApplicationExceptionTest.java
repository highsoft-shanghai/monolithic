package ltd.highsoft.frameworks.application.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationExceptionTest {

    @Test
    void should_be_instance_of_unchecked_exception() {
        ApplicationException exception = new ApplicationException();
        assertThat(exception).isInstanceOf(RuntimeException.class);
    }

}

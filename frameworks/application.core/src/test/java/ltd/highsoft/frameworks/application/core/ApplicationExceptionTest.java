package ltd.highsoft.frameworks.application.core;

import ltd.highsoft.frameworks.domain.core.DomainException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationExceptionTest {

    @Test
    void should_be_instance_of_domain_exception() {
        assertThat(new ApplicationException("error-code")).isInstanceOf(DomainException.class);
    }

    @Test
    void should_be_able_to_carry_data() {
        assertThat(new ApplicationException("error-code", 1, 2)).hasMessage("error-code: [1, 2]");
    }

    @Test
    void should_be_able_to_carry_cause() {
        assertThat(new ApplicationException("error-code", new RuntimeException("test"))).hasCauseInstanceOf(RuntimeException.class);
    }

    @Test
    void should_be_able_to_carry_cause_and_date() {
        ApplicationException exception = new ApplicationException("error-code", new RuntimeException("test"), 1, 2, 3);
        assertThat(exception).hasCauseInstanceOf(RuntimeException.class);
        assertThat(exception.data()).containsExactly(1, 2, 3);
    }

}

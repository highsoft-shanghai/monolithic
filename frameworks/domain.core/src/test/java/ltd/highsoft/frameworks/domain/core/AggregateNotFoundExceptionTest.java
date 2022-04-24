package ltd.highsoft.frameworks.domain.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AggregateNotFoundExceptionTest {

    @Test
    void should_be_able_to_carry_rich_error_information() {
        AggregateNotFoundException exception = new AggregateNotFoundException("error.object-not-found", "order", "1");
        assertThat(exception).isInstanceOf(DomainException.class);
        assertThat(exception).hasMessage("error.object-not-found");
        assertThat(exception.data()).containsExactly("order", "1");
    }

}

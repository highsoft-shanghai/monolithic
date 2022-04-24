package ltd.highsoft.frameworks.domain.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

public class DomainExceptionTest {

    private @Mock MessageResolver messageResolver;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void should_not_be_checked_exception() {
        assertThat(new DomainException()).isInstanceOf(RuntimeException.class);
    }

    @Test
    void should_be_able_to_format_as_message() {
        given(messageResolver.resolve("error.a-test-message-code")).willReturn("Error message from resolver");
        DomainException exception = new DomainException("error.a-test-message-code");
        assertThat(exception.format(messageResolver)).isEqualTo("Error message from resolver");
    }

}

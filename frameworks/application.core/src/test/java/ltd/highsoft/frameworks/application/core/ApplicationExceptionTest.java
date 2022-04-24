package ltd.highsoft.frameworks.application.core;

import ltd.highsoft.frameworks.domain.core.MessageResolver;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@MockitoSettings
class ApplicationExceptionTest {

    private @Mock MessageResolver messageResolver;

    @Test
    void should_be_instance_of_unchecked_exception() {
        ApplicationException exception = new ApplicationException("error-code");
        assertThat(exception).isInstanceOf(RuntimeException.class);
        assertThat(exception).hasMessage("error-code");
    }

    @Test
    void should_be_able_to_format_as_message() {
        given(messageResolver.resolve("error-code")).willReturn("Error message");
        ApplicationException exception = new ApplicationException("error-code");
        assertThat(exception.format(messageResolver)).isEqualTo("Error message");
    }

}

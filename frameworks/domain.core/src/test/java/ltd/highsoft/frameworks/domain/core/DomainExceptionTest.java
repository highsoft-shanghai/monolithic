package ltd.highsoft.frameworks.domain.core;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@MockitoSettings
public class DomainExceptionTest {

    private @Mock MessageResolver messageResolver;

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

    @Test
    void should_be_able_to_format_as_message_with_data() {
        given(messageResolver.resolve("error.a-test-message-code", "seg1", "seg2")).willReturn("Error message from resolver");
        DomainException exception = new DomainException("error.a-test-message-code", "seg1", "seg2");
        assertThat(exception.format(messageResolver)).isEqualTo("Error message from resolver");
    }

}

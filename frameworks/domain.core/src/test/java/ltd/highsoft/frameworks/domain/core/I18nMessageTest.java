package ltd.highsoft.frameworks.domain.core;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

import static ltd.highsoft.frameworks.domain.core.I18nMessage.message;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@MockitoSettings
public class I18nMessageTest {

    private @Mock MessageResolver messageResolver;

    @Test
    void should_be_able_to_format_as_plan_text() {
        var message = message("message-code");
        given(messageResolver.resolve("message-code")).willReturn("message-from-message-resolver");
        assertThat(message.format(messageResolver)).isEqualTo("message-from-message-resolver");
    }

}

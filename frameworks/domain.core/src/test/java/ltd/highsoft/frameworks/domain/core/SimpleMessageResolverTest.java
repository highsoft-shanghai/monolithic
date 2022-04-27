package ltd.highsoft.frameworks.domain.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleMessageResolverTest {

    @Test
    void should_be_able_to_resolve_message_as_code_and_data_in_string_manner() {
        MessageResolver messageResolver = new SimpleMessageResolver();
        assertThat(messageResolver.resolve("a-code", "a", "b")).isEqualTo("a-code: [a, b]");
    }

}

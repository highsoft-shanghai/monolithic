package ltd.highsoft.frameworks.domain.core;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MapBasedValueSinkTest {

    @Test
    void should_be_able_to_accept_string_values() {
        var sink = new MapBasedValueSink();
        sink.put("id", "token-id");
        assertThat(sink.values()).isEqualTo(Map.of("id", "token-id"));
    }

}

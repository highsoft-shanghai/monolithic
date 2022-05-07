package ltd.highsoft.frameworks.domain.core;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GlobalValueSinkFactoryTest {

    @Test
    void should_be_able_to_create_value_sinks() {
        var valueSink = GlobalValueSinkFactory.createValueSink(sink -> sink.put("id", "token-id"));
        assertThat(valueSink.toMap()).isEqualTo(Map.of("id", "token-id"));
    }

}

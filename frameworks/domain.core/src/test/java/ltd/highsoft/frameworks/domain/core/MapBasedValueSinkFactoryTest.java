package ltd.highsoft.frameworks.domain.core;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MapBasedValueSinkFactoryTest {

    @Test
    void should_be_able_to_create_value_sinks_and_initialize_them() {
        var factory = new MapBasedValueSinkFactory();
        assertThat(factory.createValueSink(sink -> sink.put("name", "John")).toMap()).isEqualTo(Map.of("name", "John"));
    }

}

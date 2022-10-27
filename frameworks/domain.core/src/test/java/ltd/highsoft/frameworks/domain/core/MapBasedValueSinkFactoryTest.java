package ltd.highsoft.frameworks.domain.core;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class MapBasedValueSinkFactoryTest {

    @Test
    void should_be_able_to_create_value_sinks_and_initialize_them() {
        MapBasedValueSinkFactory factory = new MapBasedValueSinkFactory();
        assertThat(factory.createValueSink(sink -> {
            sink.put("name", "John");
            sink.put("empty", (String) null);
        }).toMap()).isEqualTo(map());
    }

    private static Map<String, String> map() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "John");
        map.put("empty", null);
        return map;
    }

}

package ltd.highsoft.frameworks.payload.core;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MapFieldTypeTest {

    @Test
    void should_be_able_to_convert_into_maps_from_maps() {
        assertThat(MapFieldType.asMap().from(ImmutableMap.of("a", "b"))).isEqualTo(ImmutableMap.of("a", "b"));
    }

}

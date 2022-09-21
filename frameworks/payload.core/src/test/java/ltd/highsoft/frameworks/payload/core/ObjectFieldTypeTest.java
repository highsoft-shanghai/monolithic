package ltd.highsoft.frameworks.payload.core;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;

import static ltd.highsoft.frameworks.payload.core.StringFieldType.asString;
import static org.assertj.core.api.Assertions.assertThat;

class ObjectFieldTypeTest {

    @Test
    void should_be_able_to_convert_into_objects_from_maps() {
        assertThat(ObjectFieldType.asObject().from(ImmutableMap.of("a", "b")).get("a", asString())).isEqualTo("b");
    }

    @Test
    void should_be_able_to_convert_into_objects_from_null_values() {
        assertThat(ObjectFieldType.asObject().nullToEmpty().from(null).get("a", asString().allowNull())).isEqualTo(null);
    }

}

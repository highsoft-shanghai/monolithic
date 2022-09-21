package ltd.highsoft.frameworks.payload.core;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;

import static ltd.highsoft.frameworks.payload.core.MapFieldType.asMap;
import static ltd.highsoft.frameworks.payload.core.ObjectFieldType.asObject;
import static ltd.highsoft.frameworks.payload.core.StringFieldType.asString;
import static org.assertj.core.api.Assertions.assertThat;

public class PayloadTest {

    @Test
    void should_be_able_to_convert_typed_values() {
        Payload payload = new Payload("a text");
        assertThat(payload.get(asString())).isEqualTo("a text");
    }

    @Test
    void should_be_able_to_read_typed_fields() {
        Payload payload = new Payload(ImmutableMap.of("name", "John"));
        assertThat(payload.get("name", asString())).isEqualTo("John");
    }

    @Test
    void should_be_able_to_read_object_fields() {
        Payload payload = new Payload(ImmutableMap.of("nested", ImmutableMap.of("name", "John")));
        assertThat(payload.get("nested", asObject()).get("name", asString())).isEqualTo("John");
    }

    @Test
    void should_be_able_to_read_objects_from_null_fields() {
        Payload payload = new Payload(ImmutableMap.of());
        assertThat(payload.get("nested", asObject().nullToEmpty()).get("name", asString().allowNull())).isEqualTo(null);
    }

    @Test
    void should_be_able_to_access_value() {
        Payload payload = new Payload(ImmutableMap.of("name", "John"));
        assertThat(payload.value()).isNotNull();
    }

    @Test
    void should_return_empty_payload() {
        assertThat(Payload.EMPTY.get(asMap())).isEmpty();
    }

}

package ltd.highsoft.frameworks.payload.core;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArrayFieldTypeTest {

    @Test
    void should_be_able_to_convert_into_lists_from_array_lists() {
        assertThat(StringFieldType.asString().array().from(Lists.newArrayList("1", "2", "3"))).containsExactly("1", "2", "3");
    }

    @Test
    void should_be_able_to_convert_into_lists_from_null_values() {
        assertThat(StringFieldType.asString().array().nullToEmpty().from(null)).isEqualTo(Lists.newArrayList());
    }

}

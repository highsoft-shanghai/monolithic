package ltd.highsoft.frameworks.domain.core;

import org.junit.jupiter.api.Test;

import static ltd.highsoft.frameworks.domain.core.MapBasedDescriptionFactory.createDescription;
import static org.assertj.core.api.Assertions.assertThat;

public class DescriptionTest {

    @Test
    void should_be_able_to_create_description_and_initialize_them() {
        Description description = createDescription(o -> {
            o.put("name", "John");
            o.put("empty", null);
        });
        assertThat(description.<String>get("name")).isEqualTo("John");
        assertThat(description.<String>get("empty")).isNull();
    }

}

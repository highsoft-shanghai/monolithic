package ltd.highsoft.frameworks.domain.core;

import org.junit.jupiter.api.Test;

import java.util.*;

import static ltd.highsoft.frameworks.domain.core.MapBasedDescriptionFactory.createDescription;
import static org.assertj.core.api.Assertions.assertThat;

public class DescriptionTest {

    @Test
    void should_be_able_to_create_description_and_initialize_them() {
        assertThat(createDescription(description -> {
            description.put("name", "John");
            description.put("empty", null);
        }).toMap()).isEqualTo(map());
    }

    private static Map<String, String> map() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "John");
        map.put("empty", null);
        return map;
    }

}

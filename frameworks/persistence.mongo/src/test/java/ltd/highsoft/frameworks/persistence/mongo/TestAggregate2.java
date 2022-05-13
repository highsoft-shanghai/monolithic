package ltd.highsoft.frameworks.persistence.mongo;

import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
public class TestAggregate2 {

    private final String name;

    public String name() {
        return name;
    }

}

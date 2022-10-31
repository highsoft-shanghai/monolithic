package ltd.highsoft.frameworks.persistence.mongo;

import lombok.*;

@ToString
@EqualsAndHashCode
public class TestAggregate {

    private final String id;
    private final String name;

    public TestAggregate(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public void verify() {
    }

}

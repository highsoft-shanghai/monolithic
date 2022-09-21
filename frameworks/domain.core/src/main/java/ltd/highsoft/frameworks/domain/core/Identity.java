package ltd.highsoft.frameworks.domain.core;

import lombok.*;

@ToString
@EqualsAndHashCode
public class Identity {

    private final Id id;
    private final String name;

    public Identity(String id, String name) {
        this.id = new Id(id);
        this.name = name;
    }

    public String id() {
        return id.id();
    }

    public String name() {
        return name;
    }

}

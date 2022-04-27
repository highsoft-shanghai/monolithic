package ltd.highsoft.frameworks.domain.core;

import lombok.*;

@ToString
@EqualsAndHashCode
public class Identity {

    private final String id;
    private final String name;

    public Identity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

}

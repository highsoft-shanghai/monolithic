package ltd.highsoft.frameworks.domain.core;

import lombok.*;
import ltd.highsoft.frameworks.domain.core.fields.*;

@ToString
@EqualsAndHashCode
public class Identity {

    private final Id id;
    private final Name name;

    public Identity(String id, String name) {
        this.id = new Id(id);
        this.name = new Name(name);
    }

    public String id() {
        return id.get();
    }

    public String name() {
        return name.get();
    }

    public void verify() {
        id.verify();
        name.verify();
    }

}

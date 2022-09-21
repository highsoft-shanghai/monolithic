package ltd.highsoft.frameworks.domain.core.fields;

import lombok.*;
import ltd.highsoft.frameworks.domain.core.GlobalIdGenerator;

@ToString
@EqualsAndHashCode
public class Id {

    private final String id;

    public Id() {
        this(GlobalIdGenerator.nextId());
    }

    public Id(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }

}

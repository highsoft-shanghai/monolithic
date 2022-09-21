package ltd.highsoft.frameworks.domain.core.fields;

import lombok.EqualsAndHashCode;
import ltd.highsoft.frameworks.domain.core.GlobalIdGenerator;

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

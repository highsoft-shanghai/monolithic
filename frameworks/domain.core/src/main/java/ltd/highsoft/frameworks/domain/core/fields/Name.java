package ltd.highsoft.frameworks.domain.core.fields;

import lombok.*;

@ToString
@EqualsAndHashCode
public class Name {

    private final String name;

    public Name(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

}

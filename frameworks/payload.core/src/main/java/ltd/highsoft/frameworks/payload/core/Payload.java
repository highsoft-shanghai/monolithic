package ltd.highsoft.frameworks.payload.core;

import java.util.HashMap;

import static ltd.highsoft.frameworks.payload.core.MapFieldType.asMap;

public class Payload {

    public static final Payload EMPTY = new Payload(new HashMap<>());
    private final Object value;

    public Payload(Object value) {
        this.value = value;
    }

    public <T> T get(FieldType<T> type) {
        return type.from(value);
    }

    public <T> T get(String key, FieldType<T> type) {
        return type.from(get(asMap()).get(key));
    }

    public Object value() {
        return value;
    }

}

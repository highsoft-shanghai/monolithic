package ltd.highsoft.frameworks.payload.core;

import java.util.*;

public class ObjectFieldType extends FieldType<Payload> {

    public static ObjectFieldType asObject() {
        return new ObjectFieldType();
    }

    public ObjectFieldType nullToEmpty() {
        setNullHandler(() -> new Payload(Collections.emptyMap()));
        return this;
    }

    @Override
    protected boolean match(Class<?> underlyingType) {
        return Map.class.isAssignableFrom(underlyingType);
    }

    @Override
    protected Payload convert(Object value) {
        return new Payload(value);
    }

}

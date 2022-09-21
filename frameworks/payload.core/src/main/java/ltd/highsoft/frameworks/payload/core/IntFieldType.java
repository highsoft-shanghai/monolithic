package ltd.highsoft.frameworks.payload.core;

public class IntFieldType extends FieldType<Integer> {

    public static IntFieldType asInt() {
        return new IntFieldType();
    }

    @Override
    protected boolean match(Class<?> underlyingType) {
        return Number.class.isAssignableFrom(underlyingType);
    }

    @Override
    protected Integer convert(Object value) {
        return ((Number) value).intValue();
    }

}

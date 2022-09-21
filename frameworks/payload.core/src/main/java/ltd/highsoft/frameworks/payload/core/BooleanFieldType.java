package ltd.highsoft.frameworks.payload.core;

public class BooleanFieldType extends FieldType<Boolean> {

    public static BooleanFieldType asBoolean() {
        return new BooleanFieldType();
    }

    @Override
    protected boolean match(Class<?> underlyingType) {
        return Boolean.class.isAssignableFrom(underlyingType);
    }

    @Override
    protected Boolean convert(Object value) {
        return (Boolean) value;
    }

}

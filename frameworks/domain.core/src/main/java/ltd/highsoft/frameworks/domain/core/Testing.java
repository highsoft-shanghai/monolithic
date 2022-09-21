package ltd.highsoft.frameworks.domain.core;

public final class Testing<Content> {

    private final Content content;

    public static <Content> Testing<Content> by(Content testing) {
        return new Testing<>(testing);
    }

    public Testing(final Content content) {
        this.content = content;
    }

    @SuppressWarnings("unchecked")
    public <Field> Field get(final String fieldName) {
        java.lang.reflect.Field field = Exceptions.evaluate(() -> content.getClass().getDeclaredField(fieldName));
        field.setAccessible(true);
        return (Field) Exceptions.evaluate(() -> field.get(content));
    }

}

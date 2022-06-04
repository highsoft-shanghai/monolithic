package ltd.highsoft.frameworks.test.web;

public final class YesNo {

    private final boolean value;

    public static String format(boolean value) {
        return value ? "Yes" : "No";
    }

    public static YesNo of(boolean value) {
        return new YesNo(value);
    }

    @Override
    public String toString() {
        return value ? "Yes" : "No";
    }

    private YesNo(boolean value) {
        this.value = value;
    }

}

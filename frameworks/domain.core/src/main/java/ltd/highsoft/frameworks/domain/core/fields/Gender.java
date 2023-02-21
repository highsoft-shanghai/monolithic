package ltd.highsoft.frameworks.domain.core.fields;

public enum Gender {
    MALE, FEMALE, SECRET, UNKNOWN;

    @Override
    public String toString() {
        return super.toString().substring(0, 1).concat(super.toString().substring(1).toLowerCase());
    }
}

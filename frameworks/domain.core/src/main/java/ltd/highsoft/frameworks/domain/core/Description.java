package ltd.highsoft.frameworks.domain.core;

public interface Description {

    void put(String key, Object value);

    <T> T get(String name);

}

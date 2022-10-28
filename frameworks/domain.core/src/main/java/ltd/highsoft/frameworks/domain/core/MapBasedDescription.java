package ltd.highsoft.frameworks.domain.core;

import java.util.*;

public class MapBasedDescription implements Description {

    private Map<String, Object> impl = new LinkedHashMap<>();

    @Override
    public void put(String key, Object value) {
        impl.put(key, value);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T get(String name) {
        return (T) this.impl.getOrDefault(name, null);
    }

    void finishInitialize() {
        this.impl = Collections.unmodifiableMap(this.impl);
    }

}

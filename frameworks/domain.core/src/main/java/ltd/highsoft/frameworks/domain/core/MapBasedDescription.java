package ltd.highsoft.frameworks.domain.core;

import java.util.*;

public class MapBasedDescription implements Description {

    private Map<String, Object> impl = new LinkedHashMap<>();

    @Override
    public void put(String key, Object value) {
        impl.put(key, value);
    }

    @Override
    public Map<String, Object> toMap() {
        return this.impl;
    }

    @Override
    public void finishInitialize() {
        this.impl = Collections.unmodifiableMap(this.impl);
    }

}

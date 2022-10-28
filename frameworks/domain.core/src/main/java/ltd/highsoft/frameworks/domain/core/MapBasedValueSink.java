package ltd.highsoft.frameworks.domain.core;

import java.util.*;

public class MapBasedValueSink implements ValueSink {

    private Map<String, Object> values = new LinkedHashMap<>();

    public Map<String, Object> values() {
        return values;
    }

    @Override
    public void put(String key, String value) {
        values.put(key, value);
    }

    @Override
    public void put(String key, Collection<String> value) {
        values.put(key, value);
    }

    @Override
    public Map<String, Object> toMap() {
        return values;
    }

    void finishInitialize() {
        this.values = Collections.unmodifiableMap(this.values);
    }

}

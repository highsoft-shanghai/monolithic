package ltd.highsoft.frameworks.domain.core;

import java.util.Map;

public interface Description {

    void put(String key, Object value);

    Map<String, Object> toMap();

    void finishInitialize();

}

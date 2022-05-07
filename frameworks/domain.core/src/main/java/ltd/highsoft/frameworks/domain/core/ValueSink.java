package ltd.highsoft.frameworks.domain.core;

import java.util.Map;

public interface ValueSink {

    void put(String id, String value);

    Map<String, Object> toMap();

}

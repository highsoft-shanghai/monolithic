package ltd.highsoft.frameworks.domain.core;

import java.util.*;

public interface ValueSink {

    void put(String key, String value);

    void put(String key, Collection<String> value);

    Map<String, Object> toMap();

}

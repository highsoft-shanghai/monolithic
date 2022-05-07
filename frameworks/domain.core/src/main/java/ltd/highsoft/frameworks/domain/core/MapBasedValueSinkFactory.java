package ltd.highsoft.frameworks.domain.core;

import java.util.function.Consumer;

public class MapBasedValueSinkFactory implements ValueSinkFactory {

    @Override
    public ValueSink createValueSink(Consumer<ValueSink> initializer) {
        MapBasedValueSink sink = new MapBasedValueSink();
        initializer.accept(sink);
        return sink;
    }

}

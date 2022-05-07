package ltd.highsoft.frameworks.domain.core;

import java.util.function.Consumer;

public final class GlobalValueSinkFactory {

    private static GlobalValueSinkFactory instance = new GlobalValueSinkFactory(new MapBasedValueSinkFactory());
    private final ValueSinkFactory factory;

    public GlobalValueSinkFactory(ValueSinkFactory factory) {
        this.factory = factory;
    }

    public static ValueSink createValueSink(Consumer<ValueSink> initializer) {
        return instance.factory.createValueSink(initializer);
    }

}

package ltd.highsoft.frameworks.domain.core;

import java.util.function.Consumer;

public final class GlobalValueSinkFactory {

    private static final GlobalValueSinkFactory INSTANCE = new GlobalValueSinkFactory(new MapBasedValueSinkFactory());
    private final ValueSinkFactory factory;

    public static ValueSink createValueSink(Consumer<ValueSink> initializer) {
        return INSTANCE.factory.createValueSink(initializer);
    }

    public GlobalValueSinkFactory(ValueSinkFactory factory) {
        this.factory = factory;
    }

}

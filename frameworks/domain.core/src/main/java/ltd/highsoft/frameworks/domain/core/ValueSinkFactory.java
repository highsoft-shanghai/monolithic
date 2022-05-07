package ltd.highsoft.frameworks.domain.core;

import java.util.function.Consumer;

public interface ValueSinkFactory {

    ValueSink createValueSink(Consumer<ValueSink> initializer);

}

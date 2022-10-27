package ltd.highsoft.frameworks.domain.core;

import java.util.function.Consumer;

public interface DescriptionFactory {

    Description create(Consumer<Description> initializer);

}

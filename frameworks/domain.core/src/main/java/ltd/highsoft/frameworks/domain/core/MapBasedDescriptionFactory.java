package ltd.highsoft.frameworks.domain.core;

import java.util.function.Consumer;

public class MapBasedDescriptionFactory implements DescriptionFactory {

    public static Description createDescription(Consumer<Description> initializer) {
        return new MapBasedDescriptionFactory().create(initializer);
    }

    @Override
    public Description create(Consumer<Description> initializer) {
        MapBasedDescription description = new MapBasedDescription();
        initializer.accept(description);
        description.finishInitialize();
        return description;
    }

}

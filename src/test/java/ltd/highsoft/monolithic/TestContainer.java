package ltd.highsoft.monolithic;

import org.testcontainers.containers.GenericContainer;

public abstract class TestContainer<T extends GenericContainer<?>> {

    protected T container;

    public final void start() {
        container = container();
        container.start();
        environment();
    }

    protected abstract T container();

    protected void environment() {
    }

}

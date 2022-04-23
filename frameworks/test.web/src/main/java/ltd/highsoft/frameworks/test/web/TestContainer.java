package ltd.highsoft.frameworks.test.web;

import org.testcontainers.lifecycle.Startable;

public abstract class TestContainer<T extends Startable> {

    private T container;

    public final void start() {
        container = createContainer();
        container.start();
        setupEnvironment();
    }

    public T container() {
        return container;
    }

    protected abstract T createContainer();

    protected void setupEnvironment() {
    }

}

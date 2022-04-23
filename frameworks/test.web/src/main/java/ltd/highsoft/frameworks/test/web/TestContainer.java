package ltd.highsoft.frameworks.test.web;

import org.testcontainers.lifecycle.Startable;

public abstract class TestContainer<T extends Startable> {

    protected T container;

    public final void start() {
        container = createContainer();
        container.start();
        setupEnvironment();
    }

    protected abstract T createContainer();

    protected void setupEnvironment() {
    }

}

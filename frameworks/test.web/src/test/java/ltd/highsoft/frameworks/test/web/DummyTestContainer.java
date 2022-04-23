package ltd.highsoft.frameworks.test.web;

import org.testcontainers.lifecycle.Startable;

public class DummyTestContainer extends TestContainer<Startable> {

    static boolean started;
    static boolean environmentSetup;

    @Override
    protected Startable createContainer() {
        return new Startable() {
            @Override
            public void start() {
                started = true;
            }

            @Override
            public void stop() {
            }
        };
    }

    @Override
    protected void setupEnvironment() {
        environmentSetup = true;
    }

}

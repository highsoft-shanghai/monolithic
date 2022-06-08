package ltd.highsoft.frameworks.test.moco;

import ltd.highsoft.frameworks.test.container.TestContainer;

import static ltd.highsoft.frameworks.test.moco.Moco.port;

public class MocoContainer extends TestContainer<MocoTestContainer> {

    public MocoContainer() {
        Moco.init();
    }

    @Override
    protected MocoTestContainer createContainer() {
        return new MocoTestContainer();
    }

    @Override
    protected void setupEnvironment() {
        System.setProperty("test.moco.url", String.format("http://localhost:%d", port()));
    }

}

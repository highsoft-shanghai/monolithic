package ltd.highsoft.frameworks.test.moco;

import ltd.highsoft.frameworks.test.container.TestContainer;

public class MocoContainer extends TestContainer<MocoTestContainer> {

    private final MocoServerConfig config;

    public MocoContainer() {
        this.config = new MocoServerConfig();
    }

    @Override
    protected MocoTestContainer createContainer() {
        return new MocoTestContainer(config);
    }

    @Override
    protected void setupEnvironment() {
        System.setProperty("test.moco.url", String.format("http://localhost:%d", config.port()));
    }

}

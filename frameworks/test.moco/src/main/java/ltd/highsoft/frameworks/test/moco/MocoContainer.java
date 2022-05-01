package ltd.highsoft.frameworks.test.moco;

import ltd.highsoft.frameworks.test.container.TestContainer;

public class MocoContainer extends TestContainer<MocoTestContainer> {

    @Override
    protected MocoTestContainer createContainer() {
        return new MocoTestContainer(new CustomizedMocoServerConfig());
    }

    @Override
    protected void setupEnvironment() {
    }

}

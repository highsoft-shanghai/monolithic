package ltd.highsoft.frameworks.test.moco;

import com.github.dreamhead.moco.Runner;
import lombok.Generated;
import org.testcontainers.lifecycle.Startable;

import static com.github.dreamhead.moco.Runner.runner;

public class MocoTestContainer implements Startable {

    private final Runner runner;

    public MocoTestContainer(MocoServerConfig config) {
        this.runner = runner(config.configure());
    }

    @Override
    public void start() {
        runner.start();
    }

    @Override
    @Generated
    public void stop() {
        runner.stop();
    }

}

package ltd.highsoft.frameworks.test.moco;

import com.github.dreamhead.moco.Runner;
import org.testcontainers.lifecycle.Startable;

import static com.github.dreamhead.moco.Runner.runner;
import static ltd.highsoft.frameworks.test.moco.Moco.server;

public class MocoTestContainer implements Startable {

    private Runner runner;

    public MocoTestContainer() {
        Moco.resetRunner(this);
        resetRunner();
    }

    @Override
    public void start() {
        runner.start();
    }

    @Override
    public void stop() {
        runner.stop();
    }

    public void resetRunner() {
        this.runner = runner(server());
    }
}

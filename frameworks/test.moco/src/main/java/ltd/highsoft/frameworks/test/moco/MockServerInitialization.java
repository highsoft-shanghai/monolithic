package ltd.highsoft.frameworks.test.moco;

import com.github.dreamhead.moco.HttpServer;
import ltd.highsoft.frameworks.domain.core.Exceptions;

import java.net.DatagramSocket;

import static com.github.dreamhead.moco.Moco.httpServer;
import static ltd.highsoft.frameworks.test.moco.MocoValidation.hit;

public final class MockServerInitialization {

    private MockServerInitialization() {
    }

    private static int port;
    private static HttpServer server;
    private static MocoTestContainer container;

    public static void resetRunner(MocoTestContainer mocoTestContainer) {
        MockServerInitialization.container = mocoTestContainer;
    }

    public static HttpServer server() {
        return server;
    }

    public static void restart() {
        container.stop();
        container.resetRunner();
        container.start();
    }

    public static void init() {
        DatagramSocket socket = Exceptions.evaluate(() -> new DatagramSocket(0));
        port = socket.getLocalPort();
        socket.close();
        server = httpServer(port, hit());
    }

    public static int port() {
        return port;
    }
}

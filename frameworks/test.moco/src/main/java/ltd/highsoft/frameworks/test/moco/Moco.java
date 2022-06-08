package ltd.highsoft.frameworks.test.moco;

import com.github.dreamhead.moco.HttpServer;
import ltd.highsoft.frameworks.domain.core.Exceptions;

import java.net.DatagramSocket;

import static com.github.dreamhead.moco.Moco.httpServer;
import static com.github.dreamhead.moco.Moco.log;
import static ltd.highsoft.frameworks.test.moco.MocoHit.hit;

public final class Moco {

    private Moco() {
    }

    private static int port;
    private static HttpServer server;
    private static MocoTestContainer container;

    public static void resetRunner(MocoTestContainer mocoTestContainer) {
        Moco.container = mocoTestContainer;
    }

    public static HttpServer server() {
        return server;
    }

    public static String url() {
        return System.getProperty("test.moco.url");
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
        server = httpServer(port, hit(), log());
    }

    public static int port() {
        return port;
    }
}

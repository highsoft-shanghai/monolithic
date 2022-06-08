package ltd.highsoft.frameworks.test.moco;

import com.github.dreamhead.moco.HttpServer;
import ltd.highsoft.frameworks.domain.core.Exceptions;

import java.net.DatagramSocket;

import static com.github.dreamhead.moco.Moco.*;
import static ltd.highsoft.frameworks.test.moco.MocoValidation.hit;

public class MocoServerConfig {

    private final int port;

    public MocoServerConfig() {
        DatagramSocket socket = Exceptions.evaluate(() -> new DatagramSocket(0));
        port = socket.getLocalPort();
        socket.close();
    }

    public HttpServer configure() {
        HttpServer server = httpServer(port, hit());
        server.request(by(uri("/ping"))).response(text("pong"));
        return server;
    }

    public int port() {
        return port;
    }
}

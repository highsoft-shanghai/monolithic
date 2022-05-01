package ltd.highsoft.frameworks.test.moco;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.net.ConnectException;

import static com.github.dreamhead.moco.Moco.httpServer;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MocoTestContainerTest {

    private Connection connection;
    private MocoTestContainer mocoServer;

    @BeforeEach
    void setUp() throws IOException {
        // TODO : Use http port 10000 to test whether moco can really stop is good ?
        connection = Connection.by("http://localhost:10000/ping");
        mocoServer = new MocoTestContainer(() -> httpServer(10000));
        mocoServer.start();
    }

    @Test
    void should_be_able_to_throw_exception_when_request_to_moco_server_but_moco_server_stopped() {
        mocoServer.stop();
        assertThrows(ConnectException.class, connection::connect);
    }

    @AfterEach
    void tearDown() {
        connection.disconnect();
    }

}

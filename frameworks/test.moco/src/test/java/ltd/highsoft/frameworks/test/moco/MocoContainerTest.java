package ltd.highsoft.frameworks.test.moco;

import ltd.highsoft.frameworks.test.container.WithTestContainers;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static com.github.dreamhead.moco.Moco.*;
import static com.github.dreamhead.moco.MocoRequestHit.times;
import static org.junit.jupiter.api.Assertions.assertEquals;

@WithTestContainers(containers = {MocoContainer.class})
public class MocoContainerTest {

    private Connection connection;

    @BeforeEach
    void setUp() throws IOException {
        connection = Connection.by("http://localhost:9999/ping");
    }

    @Test
    void should_be_able_to_start_one_moco_container_at_target_port() throws IOException {
        connection.connect();
        assertEquals(connection.responseCode(), 200);
        assertEquals(connection.responseBody(), "pong");
        MocoValidation.hit().verify(by(uri("/ping")), times(1));
    }

    @AfterEach
    void tearDown() {
        connection.disconnect();
    }

}

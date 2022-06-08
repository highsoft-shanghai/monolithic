package ltd.highsoft.frameworks.test.moco;

import ltd.highsoft.frameworks.test.container.WithTestContainers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.github.dreamhead.moco.Moco.*;
import static com.github.dreamhead.moco.MocoRequestHit.times;
import static ltd.highsoft.frameworks.test.moco.MockServerInitialization.restart;
import static ltd.highsoft.frameworks.test.moco.MockServerInitialization.server;
import static ltd.highsoft.frameworks.test.moco.MocoValidation.hit;
import static org.junit.jupiter.api.Assertions.assertEquals;

@WithTestContainers(containers = {MocoContainer.class})
public class MocoContainer2Test {

    private Connection connection;

    @BeforeEach
    void setUp() {
        server().request(by(uri("/ping2"))).response(text("pong"));
        restart();
        String url = System.getProperty("test.moco.url");
        connection = Connection.by(url + "/ping2");
    }

    @Test
    void should_be_able_to_start_one_moco_container_at_target_port() throws IOException {
        connection.connect();
        assertEquals(connection.responseCode(), 200);
        assertEquals(connection.responseBody(), "pong");
        hit().verify(by(uri("/ping2")), times(1));
    }

    @AfterEach
    void tearDown() {
        connection.disconnect();
    }

}

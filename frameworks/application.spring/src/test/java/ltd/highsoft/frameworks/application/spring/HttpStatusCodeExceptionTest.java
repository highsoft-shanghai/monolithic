package ltd.highsoft.frameworks.application.spring;

import io.restassured.specification.RequestSpecification;
import ltd.highsoft.frameworks.security.core.ContextProvider;
import org.junit.jupiter.api.*;
import org.mockito.BDDMockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpStatusCodeExceptionTest {

    private @LocalServerPort int port;
    private @MockBean ContextProvider contextProvider;

    @BeforeEach
    void setUp() {
        BDDMockito.given(contextProvider.get(any())).willReturn(Optional.empty());
    }

    @Test
    void should_translate_aggregate_not_found_exception_to_http_404() {
        when().post("/test/trigger-aggregate-not-found-exception").then().statusCode(404).body("message", is("error.aggregate-not-found"));
    }

    @Test
    void should_translate_bad_input_exception_to_http_400() {
        when().post("/test/trigger-bad-input-exception").then().statusCode(400).body("message", is("error.bad-input"));
    }

    @Test
    void should_translate_authentication_exception_to_http_401() {
        when().post("/test/trigger-authentication-exception").then().statusCode(401).body("message", is("error.bad-credential"));
    }

    @Test
    void should_translate_authorization_exception_to_http_403() {
        when().post("/test/trigger-authorization-exception").then().statusCode(403).body("message", is("error.access-denied"));
    }

    private RequestSpecification when() {
        return given().port(port).when();
    }

}

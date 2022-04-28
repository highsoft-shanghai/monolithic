package ltd.highsoft.frameworks.application.spring;

import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpStatusCodeExceptionTest {

    private @LocalServerPort int port;

    @Test
    void should_translate_aggregate_not_found_exception_to_http_404() {
        when().post("/test/trigger-aggregate-not-found-exception").then().statusCode(404).body("message", is("error.aggregate-not-found"));
    }

    @Test
    void should_translate_illegal_argument_exception_to_http_400() {
        when().post("/test/trigger-illegal_argument_exception").then().statusCode(400).body("message", is("error.bad-input"));
    }

    @Test
    void should_translate_authentication_exception_to_http_401() {
        when().post("/test/trigger-authentication_exception").then().statusCode(401).body("message", is("error.bad-credential"));
    }

    @Test
    void should_translate_authorization_exception_to_http_403() {
        when().post("/test/trigger-authorization_exception").then().statusCode(403).body("message", is("error.access-denied"));
    }

    private RequestSpecification when() {
        return given().port(port).when();
    }

}
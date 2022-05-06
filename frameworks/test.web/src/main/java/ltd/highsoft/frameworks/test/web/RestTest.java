package ltd.highsoft.frameworks.test.web;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.web.server.LocalServerPort;

import javax.annotation.Resource;
import java.lang.reflect.Method;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Stream.concat;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.document;

@AutoConfigureRestDocs
public class RestTest {

    private @Resource RequestSpecification spec;
    private @LocalServerPort int port;
    private TestInfo testInfo;

    @BeforeEach
    void setupTestInfo(TestInfo testInfo) {
        this.testInfo = testInfo;
    }

    protected ValidatableResponse get(String path) {
        return given().when().get(path).then();
    }

    protected RequestSpecification given() {
        return givenAuth(RestAssured.given(spec)).port(port).accept(ContentType.JSON).contentType(ContentType.JSON).filter(document(documentKey()));
    }

    private RequestSpecification givenAuth(RequestSpecification requestSpecification) {
        return GlobalTestContext.accessToken().map(x -> requestSpecification.auth().oauth2(x)).orElse(requestSpecification);
    }

    private String documentKey() {
        return concat(testInfo.getTestClass().stream().map(Class::getName), testInfo.getTestMethod().stream().map(Method::getName)).collect(joining("."));
    }

}

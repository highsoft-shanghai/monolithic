package ltd.highsoft.monolithic;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.web.server.LocalServerPort;

import javax.annotation.Resource;
import java.lang.reflect.Method;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Stream.concat;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.document;

@IntegrationTest
@AutoConfigureRestDocs
public class RestTest {

    private @Resource RequestSpecification spec;
    private @LocalServerPort int port;
    private TestInfo testInfo;

    @BeforeEach
    void setupTestInfo(TestInfo testInfo) {
        this.testInfo = testInfo;
    }

    protected RequestSpecification given() {
        return RestAssured.given(spec).port(port).accept(ContentType.JSON).filter(document(documentKey()));
    }

    private String documentKey() {
        return concat(testInfo.getTestClass().stream().map(Class::getName), testInfo.getTestMethod().stream().map(Method::getName)).collect(joining("."));
    }

}
package ltd.highsoft.frameworks.test.web;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveOAuth2HeaderScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.restdocs.ManualRestDocumentation;
import org.springframework.restdocs.restassured3.RestAssuredOperationPreprocessorsConfigurer;

import java.lang.reflect.Method;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.documentationConfiguration;

@AutoConfigureRestDocs
public class RestTest {

    private final ManualRestDocumentation documentation = new ManualRestDocumentation();
    private RequestSpecification spec;
    private @LocalServerPort int port;

    protected ValidatableResponse get(String path, Filter filter) {
        return given(filter).when().get(path).then();
    }

    protected ValidatableResponse get(String path, RequestParameters parameters, Filter filter) {
        return given(filter).params(parameters.asMap()).when().get(path).then();
    }

    protected ValidatableResponse post(String path, PathVariables variables, Object body, Filter filter) {
        return given(filter).pathParams(variables.asMap()).body(body).contentType(ContentType.JSON).when().post(path).then();
    }

    protected RequestSpecification given(Filter filter) {
        return givenAuth(RestAssured.given(spec)).port(port).accept(ContentType.JSON).contentType(ContentType.JSON).filter(filter);
    }

    private RequestSpecification givenAuth(RequestSpecification requestSpecification) {
        return GlobalTestContext.accessToken().map(x -> requestSpecification.auth().oauth2(x)).orElse(requestSpecification);
    }

    @BeforeEach
    void setupRestDoc(TestInfo info) {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        GlobalTestContext.accessToken().ifPresent(x -> givenAuth(builder, x));
        this.spec = builder.addFilter(documentationFilter()).build();
        this.documentation.beforeTest(getClass(), info.getTestMethod().map(Method::getName).orElse(""));
    }

    private void givenAuth(RequestSpecBuilder builder, String token) {
        var scheme = new PreemptiveOAuth2HeaderScheme();
        scheme.setAccessToken(token);
        builder.setAuth(scheme);
    }

    private RestAssuredOperationPreprocessorsConfigurer documentationFilter() {
        return documentationConfiguration(this.documentation).operationPreprocessors().withRequestDefaults(prettyPrint()).withResponseDefaults(prettyPrint());
    }

    @AfterEach
    void tearDownRestDoc() {
        this.documentation.afterTest();
    }

}

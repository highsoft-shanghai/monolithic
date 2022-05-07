package ltd.highsoft.frameworks.test.web;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static ltd.highsoft.frameworks.test.web.ApiDocUtils.*;
import static ltd.highsoft.frameworks.test.web.ConstrainedFields.constrainedFieldWithPath;
import static ltd.highsoft.frameworks.test.web.ConstrainedParameters.parameterWithConstraints;
import static ltd.highsoft.frameworks.test.web.PathVariables.variables;
import static ltd.highsoft.frameworks.test.web.RequestParameters.parameters;
import static org.hamcrest.Matchers.is;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.document;

public class DocumentationTest extends IntegrationTest {

    @Test
    void should_be_able_to_generate_document_header() {
        var response = get("/web-test/api-header/{id}", variables(Map.of("id", "5")), document("api-header",
            apiHeader(true)
        ));
        response.statusCode(is(200));
    }

    @Test
    void should_be_able_to_document_path_variables_and_constrained_fields() {
        var response = post("/web-test/document-constrained-fields/{id}", variables(Map.of("id", "5")), Map.of("name", "John"), document("constrained-fields",
            requestFields(
                constrainedFieldWithPath("name", "Can NOT be empty").description("Name for new user")
            ))
        );
        response.statusCode(is(200));
    }

    @Test
    void should_be_able_to_document_constrained_parameters() {
        var parameters = parameters(Map.of("q", "john", "size", 10, "page", 0));
        var response = get("/web-test/document-constrained-parameters", parameters, document("constrained-parameters",
            pagedRequestParameters(
                parameterWithConstraints("q", "String", "Can NOT be empty").description("Keyword for searching")
            ))
        );
        response.statusCode(is(200));
    }

    @Test
    void should_be_able_to_document_paged_responses() {
        var response = get("/web-test/document-paged-response", parameters(Map.of()), document("paged-response",
            pagedResponseFields(
                fieldWithPath("content[].name").description("User name")
            ))
        );
        response.statusCode(is(200));
    }

}

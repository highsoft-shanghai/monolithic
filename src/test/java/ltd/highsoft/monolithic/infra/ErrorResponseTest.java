package ltd.highsoft.monolithic.infra;

import ltd.highsoft.frameworks.test.web.*;
import ltd.highsoft.monolithic.IntegrationTest;
import org.junit.jupiter.api.Test;

import static ltd.highsoft.frameworks.test.web.Documentation.doc;
import static org.hamcrest.Matchers.is;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;

public class ErrorResponseTest extends IntegrationTest {

    @Test
    @WithGrantedAuthorities("f1")
    void should_report_error_info_correctly() {
        removeAccessToken();
        var response = get("/access-tokens/current", document());
        response.statusCode(is(401));
        response.body("message", is("error.bad-token"));
    }

    private Documentation document() {
        return doc("error.general-error",
            responseFields(
                fieldWithPath("timestamp").description("错误发生时间"),
                fieldWithPath("status").description("HTTP状态码"),
                fieldWithPath("error").description("HTTP状态描述"),
                fieldWithPath("message").description("本地化错误描述"),
                fieldWithPath("path").description("资源路程")
            )
        );
    }

}

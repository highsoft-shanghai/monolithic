package ltd.highsoft.monolithic.usecases.iam;

import ltd.highsoft.frameworks.test.web.*;
import ltd.highsoft.monolithic.*;
import org.junit.jupiter.api.Test;

import static ltd.highsoft.frameworks.test.web.Documentation.doc;
import static org.hamcrest.Matchers.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;

public class GetAccessTokenContentUseCaseTest extends ApiTest {

    @Test
    @WithGrantedAuthorities({"feature-1", "feature-2"})
    void should_be_able_to_get_content_of_current_access_token() {
        var response = get("/access-tokens/current", document());
        response.statusCode(is(200)).body("accessToken", is("tester-token-id")).body("authorities", hasItems("feature-1", "feature-2"));
    }

    @Override
    public Documentation document() {
        return doc("access-tokens.current.get",
            responseFields(
                fieldWithPath("accessToken").description("访问令牌标识"),
                fieldWithPath("authorities").description("授予的权限集合")
            )
        );
    }

}

package ltd.highsoft.monolithic.usecases.iam;

import ltd.highsoft.frameworks.security.core.Authorities;
import ltd.highsoft.frameworks.test.web.WithGrantedAuthorities;
import ltd.highsoft.monolithic.IntegrationTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.document;

public class GetAccessTokenContentUseCaseTest extends IntegrationTest {

    @Test
    @WithGrantedAuthorities(Authorities.AUTHENTICATED)
    void should_be_able_to_get_content_of_current_access_token() {
        var response = get("/access-tokens/current", document("access-tokens.current.get",
            pathParameters(
            ),
            responseFields(
                fieldWithPath("accessToken").description("访问令牌标识"),
                fieldWithPath("authorities").description("授予的权限集合")
            )
        ));
        response.statusCode(is(200));
        response.body("accessToken", is("tester-access-token"));
        response.body("authorities", hasItems("feature-1", "feature-2"));
    }

}

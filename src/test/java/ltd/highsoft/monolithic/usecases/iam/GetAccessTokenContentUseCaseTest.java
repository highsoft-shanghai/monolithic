package ltd.highsoft.monolithic.usecases.iam;

import ltd.highsoft.frameworks.security.core.Authorities;
import ltd.highsoft.frameworks.test.web.WithGrantedAuthorities;
import ltd.highsoft.monolithic.IntegrationTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

public class GetAccessTokenContentUseCaseTest extends IntegrationTest {

    @Test
    @WithGrantedAuthorities(Authorities.AUTHENTICATED)
    void should_be_able_to_get_content_of_current_access_token() {
        var response = get("/access-tokens/current");
        response.statusCode(is(200));
        response.body("accessToken", is("tester-access-token"));
    }

}

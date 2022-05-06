package ltd.highsoft.monolithic.usecases.iam;

import ltd.highsoft.monolithic.IntegrationTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

public class GetAccessTokenContentUseCaseTest extends IntegrationTest {

    @Test
    void should_be_able_to_get_content_of_current_access_token() {
        var response = get("/access-tokens/current");
        response.statusCode(is(200));
        response.body("accessToken", is("test-access-token"));
    }

}

package ltd.highsoft.monolithic.usecases.iam;

import io.restassured.response.ValidatableResponse;
import ltd.highsoft.monolithic.IntegrationTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

public class GetAccessTokenContentUseCaseTest extends IntegrationTest {

    @Test
    void should_be_able_to_get_access_token_content_from_system() {
        ValidatableResponse response = get("/access-tokens/current");
        response.statusCode(is(200));
    }

}

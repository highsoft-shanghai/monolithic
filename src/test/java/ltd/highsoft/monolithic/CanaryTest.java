package ltd.highsoft.monolithic;

import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CanaryTest extends RestTest {

    @Test
    void should_be_able_to_run_tests() {
        assertThat("ok").isEqualTo("ok");
        ResponseBody<?> body = given().get("/not-found").body();
        assertThat(body.<Number>path("status")).isEqualTo(404);
    }

}

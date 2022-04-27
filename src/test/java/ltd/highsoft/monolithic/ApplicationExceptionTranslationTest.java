package ltd.highsoft.monolithic;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

public class ApplicationExceptionTranslationTest extends IntegrationTest {

    @Test
    void should_translate_aggregate_not_found_exception_to_http_not_found() {
        given().post("/test/trigger-aggregate-not-found-exception").then().assertThat().statusCode(404).body("message", is("Order '1' is not found"));
    }

}

package ltd.highsoft.frameworks.test.web;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AuthRequiredTest {

    @Test
    void should_return_false_when_GlobalTestContext_is_empty() {
        GlobalTestContext.reset();
        assertFalse(AuthRequired.authRequired());
    }

    @Test
    void should_return_false_when_GlobalTestContext_is_anonymous() {
        GlobalTestContext.teardown();
        assertFalse(AuthRequired.authRequired());
    }

    @Test
    void should_return_true_when_GlobalTestContext_has_context() {
        GlobalTestContext.setup(null);
        assertTrue(AuthRequired.authRequired());
    }

}

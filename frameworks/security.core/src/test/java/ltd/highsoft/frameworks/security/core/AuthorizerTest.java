package ltd.highsoft.frameworks.security.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class AuthorizerTest {

    @Test
    void should_be_able_to_authorize_requests_against_security_context() {
        Principal principal = Principal.create(GrantedAuthorities.of("f1"), GrantedDataAuthorities.EMPTY);
        SecurityContextResetter.reset(principal);
        Authorizer authorizer = new Authorizer();
        assertDoesNotThrow(() -> authorizer.authorize("f1", "f2"));
        SecurityContextResetter.reset();
    }

}

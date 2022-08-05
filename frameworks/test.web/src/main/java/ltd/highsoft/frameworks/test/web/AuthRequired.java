package ltd.highsoft.frameworks.test.web;

import static ltd.highsoft.frameworks.security.core.Context.ANONYMOUS;

public final class AuthRequired {

    private AuthRequired() {
    }

    public static boolean authRequired() {
        if (GlobalTestContext.token().isEmpty()) return false;
        return !GlobalTestContext.token().get().equals(ANONYMOUS.securityContext().token());
    }

}

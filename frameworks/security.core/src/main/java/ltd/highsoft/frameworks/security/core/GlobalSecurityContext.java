package ltd.highsoft.frameworks.security.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GlobalSecurityContext {

    private static final ThreadLocal<SecurityContext> PRINCIPAL = new ThreadLocal<>();

    public static SecurityContext principal() {
        return PRINCIPAL.get();
    }

    static void reset(SecurityContext context) {
        PRINCIPAL.set(context);
    }

    static void reset() {
        PRINCIPAL.set(SecurityContext.ANONYMOUS);
    }

}

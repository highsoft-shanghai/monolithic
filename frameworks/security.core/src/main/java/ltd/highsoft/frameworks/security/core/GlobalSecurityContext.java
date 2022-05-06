package ltd.highsoft.frameworks.security.core;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GlobalSecurityContext {

    private static final ThreadLocal<SecurityContext> CONTEXT = new ThreadLocal<>();

    public static SecurityContext securityContext() {
        return CONTEXT.get();
    }

    static void reset(SecurityContext context) {
        CONTEXT.set(context);
    }

    static void reset() {
        CONTEXT.set(SecurityContext.ANONYMOUS);
    }

}

package ltd.highsoft.frameworks.security.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GlobalSecurityContext {

    private static final ThreadLocal<Principal> PRINCIPAL = new ThreadLocal<>();

    public static Principal principal() {
        return PRINCIPAL.get();
    }

    static void reset(Principal principal) {
        PRINCIPAL.set(principal);
    }

    static void reset() {
        PRINCIPAL.set(Principal.ANONYMOUS);
    }

}

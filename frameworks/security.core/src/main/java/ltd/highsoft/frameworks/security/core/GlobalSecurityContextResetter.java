package ltd.highsoft.frameworks.security.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GlobalSecurityContextResetter {

    public static void reset(SecurityContext context) {
        GlobalSecurityContext.reset(context);
    }

    public static void clear() {
        GlobalSecurityContext.reset();
    }

}

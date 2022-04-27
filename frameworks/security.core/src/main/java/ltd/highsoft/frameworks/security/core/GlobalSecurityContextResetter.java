package ltd.highsoft.frameworks.security.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GlobalSecurityContextResetter {

    public static void reset(Principal principal) {
        GlobalSecurityContext.reset(principal);
    }

    public static void clear() {
        GlobalSecurityContext.reset();
    }

}

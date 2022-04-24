package ltd.highsoft.frameworks.security.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SecurityContextResetter {

    public static void reset(Principal principal) {
        SecurityContext.reset(principal);
    }

    public static void reset() {
        SecurityContext.reset();
    }

}

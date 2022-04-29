package ltd.highsoft.frameworks.context.core;

import lombok.*;
import ltd.highsoft.frameworks.domain.core.Identity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GlobalUserContext {

    private static final ThreadLocal<UserContext> CONTEXT = new ThreadLocal<>();

    public static Identity currentUserAccount() {
        return context().userAccount();
    }

    static void reset(UserContext context) {
        CONTEXT.set(context);
    }

    private static UserContext context() {
        return CONTEXT.get();
    }

}

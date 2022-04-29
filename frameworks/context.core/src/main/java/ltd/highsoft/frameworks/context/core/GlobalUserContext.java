package ltd.highsoft.frameworks.context.core;

import lombok.*;
import ltd.highsoft.frameworks.domain.core.Identity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GlobalUserContext {

    private static final ThreadLocal<UserContext> CONTEXT = new ThreadLocal<>();

    public static Identity currentUserAccount() {
        return context().userAccount();
    }

    public static String currentUserAccountId() {
        return currentUserAccount().id();
    }

    public static Identity currentUser() {
        return context().user();
    }

    public static String currentUserId() {
        return currentUser().id();
    }

    public static Identity currentTenant() {
        return context().tenant();
    }

    public static String currentTenantId() {
        return currentTenant().id();
    }

    public static UserContext userContext() {
        return context();
    }

    static void reset(UserContext context) {
        CONTEXT.set(context);
    }

    private static UserContext context() {
        return CONTEXT.get();
    }

}

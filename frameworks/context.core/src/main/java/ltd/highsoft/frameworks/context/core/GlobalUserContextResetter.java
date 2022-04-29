package ltd.highsoft.frameworks.context.core;

public class GlobalUserContextResetter {

    public static void reset(UserContext context) {
        GlobalUserContext.reset(context);
    }

    public static void clear() {
    }

}

package ltd.highsoft.frameworks.security.core;

import ltd.highsoft.frameworks.context.core.UserContext;

public interface Context {

    UserContext userContext();

    SecurityContext securityContext();

}

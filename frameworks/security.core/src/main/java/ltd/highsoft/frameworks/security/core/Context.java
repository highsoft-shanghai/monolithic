package ltd.highsoft.frameworks.security.core;

import ltd.highsoft.frameworks.context.core.UserContext;

public interface Context {

    Context INVALID = new SimpleContext(UserContext.INVALID, SecurityContext.INVALID);

    UserContext userContext();

    SecurityContext securityContext();

}

package ltd.highsoft.frameworks.context.core;

import ltd.highsoft.frameworks.domain.core.Identity;

public interface UserContext {

    Identity ANONYMOUS_IDENTITY = new Identity("anonymous", "Anonymous");
    UserContext ANONYMOUS = new SimpleUserContext(ANONYMOUS_IDENTITY, ANONYMOUS_IDENTITY, ANONYMOUS_IDENTITY);
    UserContext INVALID = new InvalidUserContext();

    Identity userAccount();

    Identity user();

    Identity tenant();

    boolean valid();

}

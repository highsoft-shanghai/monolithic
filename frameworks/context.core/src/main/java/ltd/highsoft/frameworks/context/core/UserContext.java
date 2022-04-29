package ltd.highsoft.frameworks.context.core;

import ltd.highsoft.frameworks.domain.core.Identity;

public interface UserContext {

    Identity ANONYMOUS_IDENTITY = new Identity("anonymous", "Anonymous");
    UserContext ANONYMOUS = new SimpleUserContext(ANONYMOUS_IDENTITY, ANONYMOUS_IDENTITY, ANONYMOUS_IDENTITY);

    Identity userAccount();

    Identity user();

    Identity tenant();

}

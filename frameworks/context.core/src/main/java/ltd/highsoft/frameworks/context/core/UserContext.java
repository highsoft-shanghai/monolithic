package ltd.highsoft.frameworks.context.core;

import ltd.highsoft.frameworks.domain.core.Identity;

public interface UserContext {

    Identity userAccount();

    Identity user();

    Identity tenant();

}

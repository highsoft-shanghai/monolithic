package ltd.highsoft.frameworks.context.core;

import ltd.highsoft.frameworks.domain.core.Identity;

public class InvalidUserContext implements UserContext {

    @Override
    public Identity userAccount() {
        return null;
    }

    @Override
    public Identity user() {
        return null;
    }

    @Override
    public Identity tenant() {
        return null;
    }

    @Override
    public boolean valid() {
        return false;
    }

}

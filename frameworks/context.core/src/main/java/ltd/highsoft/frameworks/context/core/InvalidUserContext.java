package ltd.highsoft.frameworks.context.core;

import ltd.highsoft.frameworks.domain.core.*;

public class InvalidUserContext implements UserContext {

    @Override
    public Identity userAccount() {
        throw new AuthenticationException("error.bad-token");
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

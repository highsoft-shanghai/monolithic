package ltd.highsoft.frameworks.context.core;

import ltd.highsoft.frameworks.domain.core.Identity;

public class SimpleUserContext implements UserContext {

    private final Identity userAccount;
    private final Identity user;
    private final Identity tenant;

    public SimpleUserContext(Identity userAccount, Identity user, Identity tenant) {
        this.userAccount = userAccount;
        this.user = user;
        this.tenant = tenant;
    }

    @Override
    public Identity userAccount() {
        return userAccount;
    }

    @Override
    public Identity user() {
        return user;
    }

    @Override
    public Identity tenant() {
        return tenant;
    }

}

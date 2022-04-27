package ltd.highsoft.frameworks.security.core;

import ltd.highsoft.frameworks.domain.core.Identity;

public class AccessTokenOwner {

    private final Identity userAccount;
    private final Identity user;
    private final Identity tenant;

    public AccessTokenOwner(Identity userAccount, Identity user, Identity tenant) {
        this.userAccount = userAccount;
        this.user = user;
        this.tenant = tenant;
    }

    public Identity userAccount() {
        return userAccount;
    }

    public Identity user() {
        return user;
    }

    public Identity tenant() {
        return tenant;
    }

}

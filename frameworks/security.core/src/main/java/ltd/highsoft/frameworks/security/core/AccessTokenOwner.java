package ltd.highsoft.frameworks.security.core;

import ltd.highsoft.frameworks.domain.core.Identity;

public class AccessTokenOwner {

    private final Identity userAccount;
    private final Identity user;

    public AccessTokenOwner(Identity userAccount, Identity user) {
        this.userAccount = userAccount;
        this.user = user;
    }

    public Identity userAccount() {
        return userAccount;
    }

    public Identity user() {
        return user;
    }

}

package ltd.highsoft.frameworks.security.core;

import lombok.*;
import ltd.highsoft.frameworks.context.core.UserContext;
import ltd.highsoft.frameworks.domain.core.Identity;

@ToString
@EqualsAndHashCode
public class AccessTokenOwner implements UserContext {

    public static final AccessTokenOwner ANONYMOUS = new AccessTokenOwner(ANONYMOUS_IDENTITY, ANONYMOUS_IDENTITY, ANONYMOUS_IDENTITY);
    private final Identity userAccount;
    private final Identity user;
    private final Identity tenant;

    public AccessTokenOwner(Identity userAccount, Identity user, Identity tenant) {
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

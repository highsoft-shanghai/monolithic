package ltd.highsoft.monolithic.iam.domain;

import lombok.*;
import ltd.highsoft.frameworks.context.core.*;
import ltd.highsoft.frameworks.domain.core.Identity;

@ToString
@EqualsAndHashCode
public class AccessTokenOwner {

    private final Identity userAccount;
    private final Identity user;
    private final Identity tenant;

    public AccessTokenOwner(Identity userAccount, Identity user, Identity tenant) {
        this.userAccount = userAccount;
        this.user = user;
        this.tenant = tenant;
    }

    public AccessTokenOwner(UserContext userContext) {
        this.userAccount = userContext.userAccount();
        this.user = userContext.user();
        this.tenant = userContext.tenant();
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

    public UserContext asUserContext() {
        return new SimpleUserContext(userAccount(), user(), tenant());
    }

    void verify() {
        userAccount.verify();
        user.verify();
        tenant.verify();
    }

}

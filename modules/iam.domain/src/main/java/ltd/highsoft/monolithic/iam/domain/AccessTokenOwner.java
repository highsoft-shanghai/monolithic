package ltd.highsoft.monolithic.iam.domain;

import lombok.*;
import ltd.highsoft.frameworks.context.core.*;
import ltd.highsoft.frameworks.domain.core.*;

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

    public UserContext asUserContext() {
        return new SimpleUserContext(userAccount, user, tenant);
    }

    void createDescription(Description description) {
        description.put("owner.userAccount.id", userAccount.id());
        description.put("owner.userAccount.name", userAccount.name());
        description.put("owner.user.id", user.id());
        description.put("owner.user.name", user.name());
        description.put("owner.tenant.id", tenant.id());
        description.put("owner.tenant.name", tenant.name());
    }

    void verify() {
        userAccount.verify();
        user.verify();
        tenant.verify();
    }

}

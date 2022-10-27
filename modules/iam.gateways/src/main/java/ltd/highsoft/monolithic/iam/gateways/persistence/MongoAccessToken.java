package ltd.highsoft.monolithic.iam.gateways.persistence;

import lombok.*;
import ltd.highsoft.frameworks.domain.core.*;
import ltd.highsoft.frameworks.security.core.GrantedAuthorities;
import ltd.highsoft.monolithic.iam.domain.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.Set;

@Document(collection = "access_tokens")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MongoAccessToken {

    private @Id String id;
    private @Field(name = "user_account_id") String userAccountId;
    private @Field(name = "user_account_name") String userAccountName;
    private @Field(name = "user_id") String userId;
    private @Field(name = "user_name") String userName;
    private @Field(name = "tenant_id") String tenantId;
    private @Field(name = "tenant_name") String tenantName;
    private @Field(name = "granted_authorities") Set<String> grantedAuthorities;

    public MongoAccessToken(AccessToken accessToken) {
        Description description = accessToken.description();
        this.id = description.get("id");
        this.userAccountId = description.get("owner.userAccount.id");
        this.userAccountName = description.get("owner.userAccount.name");
        this.userId = description.get("owner.user.id");
        this.userName = description.get("owner.user.name");
        this.tenantId = description.get("owner.tenant.id");
        this.tenantName = description.get("owner.tenant.name");
        this.grantedAuthorities = description.get("authorities");
    }

    public AccessToken asDomain() {
        return AccessToken.restore(
            id, new AccessTokenOwner(new Identity(userAccountId, userAccountName), new Identity(userId, userName), new Identity(tenantId, tenantName)),
            GrantedAuthorities.of(grantedAuthorities)
        );
    }

}

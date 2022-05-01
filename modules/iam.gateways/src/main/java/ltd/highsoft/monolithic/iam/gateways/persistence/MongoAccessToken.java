package ltd.highsoft.monolithic.iam.gateways.persistence;

import lombok.*;
import ltd.highsoft.frameworks.domain.core.Identity;
import ltd.highsoft.frameworks.security.core.*;
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
        this.id = accessToken.token();
        this.userAccountId = accessToken.owner().userAccount().id();
        this.userAccountName = accessToken.owner().userAccount().name();
        this.userId = accessToken.owner().user().id();
        this.userName = accessToken.owner().user().name();
        this.tenantId = accessToken.owner().tenant().id();
        this.tenantName = accessToken.owner().tenant().name();
        this.grantedAuthorities = accessToken.grantedAuthorities().asSet();
    }

    public AccessToken asDomain() {
        return AccessToken.restore(
            id, new AccessTokenOwner(new Identity(userAccountId, userAccountName), new Identity(userId, userName), new Identity(tenantId, tenantName)),
            GrantedAuthorities.of(grantedAuthorities)
        );
    }

}

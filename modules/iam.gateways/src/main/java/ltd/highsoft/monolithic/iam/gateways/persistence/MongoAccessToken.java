package ltd.highsoft.monolithic.iam.gateways.persistence;

import lombok.*;
import ltd.highsoft.frameworks.domain.core.Identity;
import ltd.highsoft.frameworks.security.core.GrantedAuthorities;
import ltd.highsoft.monolithic.iam.domain.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.*;

import static ltd.highsoft.frameworks.domain.core.GlobalValueSinkFactory.createValueSink;

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

    @SuppressWarnings("unchecked")
    public MongoAccessToken(AccessToken accessToken) {
        Map<String, Object> sinkMap = createValueSink(accessToken::fullContent).toMap();
        this.id = (String) sinkMap.get("id");
        this.userAccountId = (String) sinkMap.get("owner.userAccount.id");
        this.userAccountName = (String) sinkMap.get("owner.userAccount.name");
        this.userId = (String) sinkMap.get("owner.user.id");
        this.userName = (String) sinkMap.get("owner.user.name");
        this.tenantId = (String) sinkMap.get("owner.tenant.id");
        this.tenantName = (String) sinkMap.get("owner.tenant.name");
        this.grantedAuthorities = (Set<String>) sinkMap.get("authorities");
    }

    public AccessToken asDomain() {
        return AccessToken.restore(
            id, new AccessTokenOwner(new Identity(userAccountId, userAccountName), new Identity(userId, userName), new Identity(tenantId, tenantName)),
            GrantedAuthorities.of(grantedAuthorities)
        );
    }

}

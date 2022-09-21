package ltd.highsoft.monolithic.iam.domain;

import ltd.highsoft.frameworks.context.core.UserContext;
import ltd.highsoft.frameworks.domain.core.ValueSink;
import ltd.highsoft.frameworks.domain.core.archtype.Aggregate;
import ltd.highsoft.frameworks.domain.core.fields.Id;
import ltd.highsoft.frameworks.security.core.*;

public final class AccessToken implements Context, Aggregate {

    private final Id id;
    private final AccessTokenOwner owner;
    private final GrantedAuthorities grantedAuthorities;

    public static AccessToken create(AccessTokenOwner owner, GrantedAuthorities authorities) {
        return new AccessToken(owner, authorities);
    }

    public static AccessToken restore(String id, AccessTokenOwner owner, GrantedAuthorities authorities) {
        return new AccessToken(id, owner, authorities);
    }

    private AccessToken(String id, AccessTokenOwner owner, GrantedAuthorities grantedAuthorities) {
        this.id = new Id(id);
        this.owner = owner;
        this.grantedAuthorities = grantedAuthorities;
    }

    private AccessToken(AccessTokenOwner owner, GrantedAuthorities grantedAuthorities) {
        this.id = new Id();
        this.owner = owner;
        this.grantedAuthorities = grantedAuthorities;
    }

    @Override
    public void verify() {
        id.verify();
        owner.verify();
    }

    public String token() {
        return id();
    }

    @Override
    public String id() {
        return this.id.get();
    }

    @Override
    public UserContext userContext() {
        return owner.asUserContext();
    }

    @Override
    public SecurityContext securityContext() {
        return new SimpleSecurityContext(token(), grantedAuthorities);
    }

    public void fullContent(ValueSink sink) {
        sink.put("id", id());
        sink.put("owner.userAccount.id", owner.asUserContext().userAccount().id());
        sink.put("owner.userAccount.name", owner.asUserContext().userAccount().name());
        sink.put("owner.user.id", owner.asUserContext().user().id());
        sink.put("owner.user.name", owner.asUserContext().user().name());
        sink.put("owner.tenant.id", owner.asUserContext().tenant().id());
        sink.put("owner.tenant.name", owner.asUserContext().tenant().name());
        sink.put("authorities", grantedAuthorities.asSet());
    }

    public void content(ValueSink sink) {
        sink.put("accessToken", token());
        sink.put("authorities", grantedAuthorities.asSet());
    }

}

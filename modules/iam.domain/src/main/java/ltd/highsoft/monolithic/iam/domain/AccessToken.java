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
        owner.fullContent(sink);
        grantedAuthorities.fullContent(sink);
    }

    public void content(ValueSink sink) {
        sink.put("accessToken", token());
        grantedAuthorities.fullContent(sink);
    }

}

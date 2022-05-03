package ltd.highsoft.monolithic.iam.domain;

import ltd.highsoft.frameworks.context.core.UserContext;
import ltd.highsoft.frameworks.security.core.*;

import static ltd.highsoft.frameworks.domain.core.GlobalIdGenerator.nextId;

public final class AccessToken implements Context {

    private final String id;
    private final AccessTokenOwner owner;
    private final GrantedAuthorities grantedAuthorities;

    public static AccessToken create(AccessTokenOwner owner, GrantedAuthorities authorities) {
        return new AccessToken(nextId(), owner, authorities);
    }

    public static AccessToken restore(String id, AccessTokenOwner owner, GrantedAuthorities authorities) {
        return new AccessToken(id, owner, authorities);
    }

    private AccessToken(String id, AccessTokenOwner owner, GrantedAuthorities grantedAuthorities) {
        this.id = id;
        this.owner = owner;
        this.grantedAuthorities = grantedAuthorities;
    }

    public AccessTokenOwner owner() {
        return owner;
    }

    public String token() {
        return id;
    }

    public GrantedAuthorities grantedAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public UserContext userContext() {
        return owner().asUserContext();
    }

    @Override
    public SecurityContext securityContext() {
        return new SimpleSecurityContext(token(), grantedAuthorities());
    }

}
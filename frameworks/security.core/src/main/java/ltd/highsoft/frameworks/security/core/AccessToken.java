package ltd.highsoft.frameworks.security.core;

import static ltd.highsoft.frameworks.domain.core.GlobalIdGenerator.nextId;

public final class AccessToken {

    private final String id;
    private final AccessTokenOwner owner;
    private final GrantedAuthorities grantedAuthorities;

    public static AccessToken create(AccessTokenOwner owner, GrantedAuthorities authorities) {
        return new AccessToken(nextId(), owner, authorities);
    }

    private AccessToken(String id, AccessTokenOwner owner, GrantedAuthorities grantedAuthorities) {
        this.id = id;
        this.owner = owner;
        this.grantedAuthorities = grantedAuthorities;
    }

    public String id() {
        return id;
    }

    public AccessTokenOwner owner() {
        return owner;
    }

    public void authorize(RequiredAuthorities requiredAuthorities) {
        if (grantedAuthorities.match(requiredAuthorities)) return;
        throw new AuthorizationException("error.access-denied", requiredAuthorities, grantedAuthorities);
    }

}

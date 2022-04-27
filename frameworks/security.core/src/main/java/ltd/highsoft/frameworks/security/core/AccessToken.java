package ltd.highsoft.frameworks.security.core;

import static ltd.highsoft.frameworks.domain.core.GlobalIdGenerator.nextId;

public final class AccessToken {

    private final String id;
    private final AccessTokenOwner owner;
    private final GrantedAuthorities authorities;

    public static AccessToken create(AccessTokenOwner owner, GrantedAuthorities authorities) {
        return new AccessToken(nextId(), owner, authorities);
    }

    private AccessToken(String id, AccessTokenOwner owner, GrantedAuthorities authorities) {
        this.id = id;
        this.owner = owner;
        this.authorities = authorities;
    }

    public String id() {
        return id;
    }

    public AccessTokenOwner owner() {
        return owner;
    }

    public void authorize(RequiredAuthorities requiredAuthorities) {
    }

}

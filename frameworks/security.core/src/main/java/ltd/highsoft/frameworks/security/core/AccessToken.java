package ltd.highsoft.frameworks.security.core;

import static ltd.highsoft.frameworks.domain.core.GlobalIdGenerator.nextId;

public final class AccessToken implements SecurityContext {

    public static final AccessToken ANONYMOUS = new AccessToken("anonymous", AccessTokenOwner.ANONYMOUS, GrantedAuthorities.ANONYMOUS);
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

    @Override
    public String token() {
        return id;
    }

    public AccessTokenOwner owner() {
        return owner;
    }

    @Override
    public void authorize(RequiredAuthorities requiredAuthorities) {
        grantedAuthorities.authorize(requiredAuthorities);
    }

    @Override
    public GrantedAuthorities grantedAuthorities() {
        return grantedAuthorities;
    }

}

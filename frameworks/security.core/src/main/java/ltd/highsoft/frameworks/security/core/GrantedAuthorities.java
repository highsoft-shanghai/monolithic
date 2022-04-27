package ltd.highsoft.frameworks.security.core;

import com.google.common.collect.Sets;
import lombok.*;

import java.util.Set;

@ToString
@EqualsAndHashCode
public final class GrantedAuthorities {

    public static final GrantedAuthorities ANONYMOUS = GrantedAuthorities.of(Authorities.ANONYMOUS);
    public static final GrantedAuthorities SYSTEM = GrantedAuthorities.of(Authorities.SYSTEM);
    private final Set<String> authorities;

    public static GrantedAuthorities of(String... authorities) {
        return new GrantedAuthorities(authorities);
    }

    public static GrantedAuthorities of(Set<String> authorities) {
        return new GrantedAuthorities(authorities);
    }

    private GrantedAuthorities(String... grantedAuthorities) {
        this.authorities = Set.of(grantedAuthorities);
    }

    private GrantedAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    public void authorize(RequiredAuthorities requiredAuthorities) {
        if (match(requiredAuthorities)) return;
        if (isAnonymous()) throw new AuthenticationException("error.authentication-required");
        throw new AuthorizationException("error.access-denied", requiredAuthorities, this);
    }

    public Set<String> asSet() {
        return authorities;
    }

    public boolean match(RequiredAuthorities requiredAuthorities) {
        if (isSpecialRole()) return true;
        if (requiredAuthorities.requireAnonymous()) return true;
        if (requiredAuthorities.requireAuthenticatedOnly() && !isAnonymous()) return true;
        return !Sets.intersection(authorities, requiredAuthorities.asSet()).isEmpty();
    }

    private boolean isSpecialRole() {
        return authorities.contains(Authorities.ADMIN) || authorities.contains(Authorities.SYSTEM);
    }

    public boolean isAnonymous() {
        return authorities.contains(Authorities.ANONYMOUS);
    }

}

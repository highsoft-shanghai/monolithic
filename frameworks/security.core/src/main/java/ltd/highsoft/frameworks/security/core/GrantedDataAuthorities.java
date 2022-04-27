package ltd.highsoft.frameworks.security.core;

import java.util.Collections;
import java.util.List;

public class GrantedDataAuthorities {

    public static final GrantedDataAuthorities EMPTY = GrantedDataAuthorities.of();
    public static final GrantedDataAuthorities SYSTEM = GrantedDataAuthorities.of();
    private final List<DataAuthority> authorities;

    public static GrantedDataAuthorities of(DataAuthority... policies) {
        return new GrantedDataAuthorities(List.of(policies));
    }

    public static GrantedDataAuthorities of(List<DataAuthority> policies) {
        return new GrantedDataAuthorities(policies);
    }

    public GrantedDataAuthorities(List<DataAuthority> authorities) {
        this.authorities = authorities;
    }

    public List<DataAuthority> asList() {
        return Collections.unmodifiableList(authorities);
    }

}

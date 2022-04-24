package ltd.highsoft.frameworks.security.core;

public interface Principal {

    Principal ANONYMOUS = create(GrantedAuthorities.ANONYMOUS, GrantedDataAuthorities.EMPTY);
    Principal SYSTEM = create(GrantedAuthorities.SYSTEM, GrantedDataAuthorities.SYSTEM);

    static Principal create(GrantedAuthorities authorities, GrantedDataAuthorities dataAuthorities) {
        return new AuthenticatedPrincipal(authorities, dataAuthorities);
    }

    void authorize(RequiredAuthorities requiredAuthorities);

    GrantedAuthorities grantedAuthorities();

    GrantedDataAuthorities grantedDataAuthorities();

}

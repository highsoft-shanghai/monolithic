package ltd.highsoft.frameworks.security.core;

public interface SecurityContext {

    SecurityContext ANONYMOUS = new SimpleSecurityContext(GrantedAuthorities.ANONYMOUS);
    SecurityContext SYSTEM = new SimpleSecurityContext(GrantedAuthorities.SYSTEM);

    void authorize(RequiredAuthorities requiredAuthorities);

    String token();

    GrantedAuthorities grantedAuthorities();

}

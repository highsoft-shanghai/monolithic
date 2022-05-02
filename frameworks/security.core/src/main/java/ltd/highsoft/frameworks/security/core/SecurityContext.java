package ltd.highsoft.frameworks.security.core;

public interface SecurityContext {

    SecurityContext ANONYMOUS = new SimpleSecurityContext("anonymous", GrantedAuthorities.ANONYMOUS);
    SecurityContext SYSTEM = new SimpleSecurityContext("simple", GrantedAuthorities.SYSTEM);

    default void authorize(RequiredAuthorities requiredAuthorities) {
        grantedAuthorities().authorize(requiredAuthorities);
    }

    String token();

    GrantedAuthorities grantedAuthorities();

}

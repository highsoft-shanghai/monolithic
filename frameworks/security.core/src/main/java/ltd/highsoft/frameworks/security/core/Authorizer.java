package ltd.highsoft.frameworks.security.core;

public class Authorizer {

    public void authorize(String... requiredAuthorities) {
        SecurityContext.principal().authorize(RequiredAuthorities.of(requiredAuthorities));
    }

}

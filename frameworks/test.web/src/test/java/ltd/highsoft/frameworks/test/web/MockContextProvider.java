package ltd.highsoft.frameworks.test.web;

import ltd.highsoft.frameworks.context.core.SimpleUserContext;
import ltd.highsoft.frameworks.domain.core.Identity;
import ltd.highsoft.frameworks.security.core.*;

import java.util.Optional;

public class MockContextProvider implements ContextProvider {

    public static final Identity USER_ACCOUNT = new Identity("tester@highsoft", "Tester");
    public static final Identity USER = new Identity("tester", "Tester");
    public static final Identity TENANT = new Identity("highsoft", "Highsoft");
    public static final SimpleSecurityContext SECURITY_CONTEXT = new SimpleSecurityContext("tester-access-token", GrantedAuthorities.of("f1", "f2"));
    public static final SimpleUserContext USER_CONTEXT = new SimpleUserContext(USER_ACCOUNT, USER, TENANT);
    public static final Context CONTEXT = new SimpleContext(USER_CONTEXT, SECURITY_CONTEXT);

    @Override
    public Optional<Context> get(String id) {
        return Optional.of(CONTEXT);
    }

}

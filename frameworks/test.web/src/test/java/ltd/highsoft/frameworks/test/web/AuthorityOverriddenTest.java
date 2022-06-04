package ltd.highsoft.frameworks.test.web;

import ltd.highsoft.frameworks.context.core.*;
import ltd.highsoft.frameworks.domain.core.Identity;
import ltd.highsoft.frameworks.security.core.*;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@WithGrantedAuthorities({"f3", "f4"})
public class AuthorityOverriddenTest extends IntegrationTest {

    private @Resource ContextProvider contextProvider;

    @Test
    void should_be_able_to_override_authorities_of_current_user() {
        Optional<Context> context = GlobalTestContext.token().flatMap(contextProvider::get);
        assertThat(context.map(Context::userContext).map(UserContext::userAccount)).hasValue(new Identity("tester@highsoft", "Tester"));
        assertThat(context.map(Context::userContext).map(UserContext::user)).hasValue(new Identity("tester", "Tester"));
        assertThat(context.map(Context::userContext).map(UserContext::tenant)).hasValue(new Identity("highsoft", "Highsoft"));
        assertThat(context.map(Context::securityContext).map(SecurityContext::token)).hasValue("tester-token-id");
        assertThat(context.map(Context::securityContext).map(SecurityContext::grantedAuthorities)).hasValue(GrantedAuthorities.of("f3", "f4"));
    }

}

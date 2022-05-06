package ltd.highsoft.frameworks.test.web;

import ltd.highsoft.frameworks.security.core.GrantedAuthorities;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

@WithGrantedAuthorities({"f3", "f4"})
public class AuthorityOverriddenTest extends IntegrationTest {

    private @Resource ContextProviderHolder contextProviderHolder;

    @Test
    void should_be_able_to_override_authorities_for_current_user() {
        var context = contextProviderHolder.contextProvider().get(GlobalTestContext.DEFAULT_TESTER_ACCESS_TOKEN);
        assertThat(GlobalTestContext.accessToken()).hasValue(GlobalTestContext.DEFAULT_TESTER_ACCESS_TOKEN);
        assertThat(context.map(x -> x.securityContext().grantedAuthorities())).hasValue(GrantedAuthorities.of("f3", "f4"));
    }

}

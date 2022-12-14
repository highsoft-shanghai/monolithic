package ltd.highsoft.frameworks.context.core;

import ltd.highsoft.frameworks.domain.core.Identity;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

class GlobalUserContextTest {

    public static final Identity JOHN_AT_HIGHSOFT = new Identity("john@highsoft", "John");
    public static final Identity JOHN = new Identity("john", "John");
    public static final Identity HIGHSOFT = new Identity("highsoft", "Highsoft");

    @BeforeEach
    void setUp() {
        GlobalUserContextResetter.reset(new SimpleUserContext(JOHN_AT_HIGHSOFT, JOHN, HIGHSOFT));
    }

    @Test
    void should_be_able_to_hold_current_user_account() {
        assertThat(GlobalUserContext.currentUserAccount()).isEqualTo(JOHN_AT_HIGHSOFT);
        assertThat(GlobalUserContext.currentUserAccountId()).isEqualTo(JOHN_AT_HIGHSOFT.id());
    }

    @Test
    void should_be_able_to_hold_current_user() {
        assertThat(GlobalUserContext.currentUser()).isEqualTo(JOHN);
        assertThat(GlobalUserContext.currentUserId()).isEqualTo(JOHN.id());
    }

    @Test
    void should_be_able_to_hold_current_tenant() {
        assertThat(GlobalUserContext.currentTenant()).isEqualTo(HIGHSOFT);
        assertThat(GlobalUserContext.currentTenantId()).isEqualTo(HIGHSOFT.id());
    }

    @Test
    void should_be_able_to_clear() {
        GlobalUserContextResetter.clear();
        assertThat(GlobalUserContext.userContext()).isEqualTo(UserContext.ANONYMOUS);
    }

    @AfterEach
    void tearDown() {
        GlobalUserContextResetter.clear();
    }

}

package ltd.highsoft.monolithic;

import ltd.highsoft.frameworks.test.container.WithTestContainers;
import ltd.highsoft.frameworks.test.moco.MocoContainer;
import ltd.highsoft.frameworks.test.mongo.MongoContainer;
import ltd.highsoft.frameworks.test.postgres.PostgresContainer;
import ltd.highsoft.frameworks.test.web.*;
import ltd.highsoft.monolithic.iam.domain.*;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WithTestContainers(containers = {PostgresContainer.class, MongoContainer.class, MocoContainer.class})
public abstract class IntegrationTest extends RestTest {

    private @Resource AccessTokens accessTokens;
    private AccessToken accessToken;

    protected void removeAccessToken() {
        if (accessToken != null) {
            accessTokens.remove(accessToken);
        }
    }

    @BeforeEach
    void setupAccessToken() {
        GlobalTestContext.context().ifPresent(context -> {
            accessToken = AccessToken.restore(context.securityContext().token(), new AccessTokenOwner(context.userContext()), context.securityContext().grantedAuthorities());
            accessTokens.add(accessToken);
        });
    }

    @AfterEach
    void teardownAccessToken() {
        removeAccessToken();
    }

}

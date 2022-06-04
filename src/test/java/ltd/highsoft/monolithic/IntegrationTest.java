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

    private @Resource AccessTokenRepository accessTokenRepository;
    private AccessToken accessToken;

    @BeforeEach
    void setupAccessToken() {
        GlobalTestContext.context().ifPresent(context -> {
            accessToken = AccessToken.restore(context.securityContext().token(), new AccessTokenOwner(context.userContext()), context.securityContext().grantedAuthorities());
            accessTokenRepository.save(accessToken);
        });
    }

    @AfterEach
    void teardownAccessToken() {
        if (accessToken != null) {
            accessTokenRepository.remove(accessToken);
        }
    }

}

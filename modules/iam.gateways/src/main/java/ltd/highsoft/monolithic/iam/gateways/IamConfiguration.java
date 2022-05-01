package ltd.highsoft.monolithic.iam.gateways;

import ltd.highsoft.frameworks.security.core.AccessTokenProvider;
import ltd.highsoft.monolithic.iam.domain.*;
import org.springframework.context.annotation.*;

@Configuration
public class IamConfiguration {

    @Bean
    public AccessTokenProvider accessTokenProvider(AccessTokenRepository accessTokenRepository) {
        return new RepositoryAccessTokenProvider(accessTokenRepository);
    }

}

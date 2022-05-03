package ltd.highsoft.monolithic.iam.gateways;

import ltd.highsoft.frameworks.security.core.ContextProvider;
import ltd.highsoft.monolithic.iam.domain.*;
import org.springframework.context.annotation.*;

@Configuration
public class IamConfiguration {

    @Bean
    public ContextProvider accessTokenProvider(AccessTokenRepository accessTokenRepository) {
        return new AccessTokenContextProvider(accessTokenRepository);
    }

}

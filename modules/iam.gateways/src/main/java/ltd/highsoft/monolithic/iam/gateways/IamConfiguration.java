package ltd.highsoft.monolithic.iam.gateways;

import ltd.highsoft.frameworks.security.core.ContextProvider;
import ltd.highsoft.monolithic.iam.domain.*;
import org.springframework.context.annotation.*;

@Configuration
public class IamConfiguration {

    @Bean
    public ContextProvider contextProvider(AccessTokens accessTokens) {
        return new AccessTokenContextProvider(accessTokens);
    }

}

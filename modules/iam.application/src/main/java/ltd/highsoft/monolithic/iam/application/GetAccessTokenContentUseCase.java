package ltd.highsoft.monolithic.iam.application;

import ltd.highsoft.frameworks.application.core.UseCase;
import ltd.highsoft.frameworks.domain.core.Identity;
import ltd.highsoft.frameworks.security.core.*;
import ltd.highsoft.monolithic.iam.domain.*;

@UseCase(requiredAuthorities = Authorities.AUTHENTICATED)
public class GetAccessTokenContentUseCase {

    public AccessToken execute() {
        return AccessToken.restore(
            "test-access-token",
            new AccessTokenOwner(new Identity("tester@highsoft", "Tester"), new Identity("tester", "Tester"), new Identity("highsoft", "Highsoft")),
            GrantedAuthorities.of()
        );
    }

}

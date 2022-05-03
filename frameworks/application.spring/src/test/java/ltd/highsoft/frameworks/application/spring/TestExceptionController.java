package ltd.highsoft.frameworks.application.spring;

import ltd.highsoft.frameworks.application.core.UseCase;
import ltd.highsoft.frameworks.domain.core.*;
import ltd.highsoft.frameworks.security.core.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@UseCase(requiredAuthorities = Authorities.ANONYMOUS)
public class TestExceptionController {

    @PostMapping("trigger-aggregate-not-found-exception")
    public void triggerAggregateNotFoundException() {
        throw new AggregateNotFoundException();
    }

    @PostMapping("trigger-illegal_argument_exception")
    public void triggerIllegalArgumentException() {
        throw new IllegalArgumentException("error.bad-input");
    }

    @PostMapping("trigger-authentication_exception")
    public void triggerAuthenticationException() {
        throw new AuthenticationException("error.bad-credential");
    }

    @PostMapping("trigger-authorization_exception")
    public void triggerAuthorizationException() {
        throw new AuthorizationException("error.access-denied", RequiredAuthorities.of("f1"), GrantedAuthorities.of("f2"));
    }

}

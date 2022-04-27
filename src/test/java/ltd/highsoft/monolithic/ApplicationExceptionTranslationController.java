package ltd.highsoft.monolithic;

import ltd.highsoft.frameworks.application.core.UseCase;
import ltd.highsoft.frameworks.domain.core.AggregateNotFoundException;
import ltd.highsoft.frameworks.security.core.Authorities;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@UseCase(requiredAuthorities = Authorities.ANONYMOUS)
public class ApplicationExceptionTranslationController {

    @PostMapping("trigger-aggregate-not-found-exception")
    public void triggerAggregateNotFoundException() {
        throw new AggregateNotFoundException("error.aggregate-not-found");
    }

}

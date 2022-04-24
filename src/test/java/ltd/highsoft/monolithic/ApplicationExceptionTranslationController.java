package ltd.highsoft.monolithic;

import ltd.highsoft.frameworks.domain.core.AggregateNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class ApplicationExceptionTranslationController {

    @PostMapping("trigger-aggregate-not-found-exception")
    public void triggerAggregateNotFoundException() {
        throw new AggregateNotFoundException("error.aggregate-not-found");
    }

}

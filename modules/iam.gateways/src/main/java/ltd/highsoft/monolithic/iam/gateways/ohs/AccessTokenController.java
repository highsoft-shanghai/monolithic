package ltd.highsoft.monolithic.iam.gateways.ohs;

import ltd.highsoft.monolithic.iam.application.GetAccessTokenContentUseCase;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

@RestController
@RequestMapping("/access-tokens")
public class AccessTokenController {

    private @Resource GetAccessTokenContentUseCase getAccessTokenContentUseCase;

    @GetMapping("current")
    public Optional<AccessTokenContent> getContent() {
        return getAccessTokenContentUseCase.execute().map(AccessTokenContent::new);
    }

}

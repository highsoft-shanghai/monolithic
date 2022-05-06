package ltd.highsoft.monolithic.iam.gateways.ohs;

import ltd.highsoft.monolithic.iam.application.GetAccessTokenContentUseCase;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/access-tokens")
public class AccessTokenController {

    private @Resource GetAccessTokenContentUseCase getAccessTokenContentUseCase;

    @GetMapping("current")
    public AccessTokenContent getContent() {
        return new AccessTokenContent(getAccessTokenContentUseCase.execute());
    }

}

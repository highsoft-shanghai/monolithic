package ltd.highsoft.monolithic.iam.gateways.ohs;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/access-tokens")
public class AccessTokenController {

    @GetMapping("current")
    public AccessTokenContent getContent() {
        return new AccessTokenContent("1");
    }

}

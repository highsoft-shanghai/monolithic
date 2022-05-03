package ltd.highsoft.monolithic.iam.gateways.ohs;

import lombok.Getter;

@Getter
public class AccessTokenContent {

    private final String accessToken;

    public AccessTokenContent(String accessToken) {
        this.accessToken = accessToken;
    }

}

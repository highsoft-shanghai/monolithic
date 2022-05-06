package ltd.highsoft.monolithic.iam.gateways.ohs;

import com.fasterxml.jackson.annotation.JsonProperty;
import ltd.highsoft.monolithic.iam.domain.AccessToken;

public class AccessTokenContent {

    private final AccessToken accessToken;

    public AccessTokenContent(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    @JsonProperty("accessToken")
    public String accessToken() {
        return accessToken.token();
    }

}

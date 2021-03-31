package rest.service.dto.request;

import com.google.gson.annotations.SerializedName;

public class AuthGuestRequest {

    @SerializedName(value = "grant_type")
    private String grantType;

    private String scope;

    public String getGrantType() {
        return grantType;
    }

    public AuthGuestRequest setGrantType(String grantType) {
        this.grantType = grantType;
        return this;
    }

    public String getScope() {
        return scope;
    }

    public AuthGuestRequest setScope(String scope) {
        this.scope = scope;
        return this;
    }
}

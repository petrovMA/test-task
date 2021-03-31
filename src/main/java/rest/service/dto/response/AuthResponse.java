package rest.service.dto.response;

import com.google.gson.annotations.SerializedName;

public class AuthResponse {

    @SerializedName(value = "token_type")
    private String tokenType;

    @SerializedName(value = "expires_in")
    private String expiresIn;

    @SerializedName(value = "access_token")
    private String accessToken;

    @SerializedName(value = "refresh_token")
    private String refreshToken;

    public String getTokenType() {
        return tokenType;
    }

    public AuthResponse setTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public AuthResponse setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public AuthResponse setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public AuthResponse setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }
}

package com.casino.api.dto.request;

import com.google.gson.annotations.SerializedName;

public class AuthPlayerRequest {

    @SerializedName(value = "grant_type")
    private String grantType;

    private String username;
    private String password;

    public String getGrantType() {
        return grantType;
    }

    public AuthPlayerRequest setGrantType(String grantType) {
        this.grantType = grantType;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public AuthPlayerRequest setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AuthPlayerRequest setPassword(String password) {
        this.password = password;
        return this;
    }
}

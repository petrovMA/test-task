package com.casino.api.dto.request;

import com.google.gson.annotations.SerializedName;

public class PlayerRegisterRequest {
    private String username;

    @SerializedName(value = "password_change")
    private String passwordChange;

    @SerializedName(value = "password_repeat")
    private String passwordRepeat;

    private String email;
    private String name;
    private String surname;

    @SerializedName(value = "currency_code")
    private String currencyCode;

    public String getUsername() {
        return username;
    }

    public PlayerRegisterRequest setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPasswordChange() {
        return passwordChange;
    }

    public PlayerRegisterRequest setPasswordChange(String passwordChange) {
        this.passwordChange = passwordChange;
        return this;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public PlayerRegisterRequest setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PlayerRegisterRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return name;
    }

    public PlayerRegisterRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public PlayerRegisterRequest setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public PlayerRegisterRequest setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }
}

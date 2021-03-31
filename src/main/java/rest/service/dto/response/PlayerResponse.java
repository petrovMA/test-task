package rest.service.dto.response;

import com.google.gson.annotations.SerializedName;

public class PlayerResponse {

    private long id;

    @SerializedName(value = "country_id")
    private String countryId;

    @SerializedName(value = "timezone_id")
    private String timezoneId;

    private String username;
    private String email;
    private String name;
    private String surname;
    private String gender;
    private String phone_number;
    private String birthdate;

    @SerializedName(value = "bonuses_allowed")
    private String bonusesAllowed;

    @SerializedName(value = "is_verified")
    private String isVerified;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getTimezoneId() {
        return timezoneId;
    }

    public void setTimezoneId(String timezoneId) {
        this.timezoneId = timezoneId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getBonusesAllowed() {
        return bonusesAllowed;
    }

    public void setBonusesAllowed(String bonusesAllowed) {
        this.bonusesAllowed = bonusesAllowed;
    }

    public String getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(String isVerified) {
        this.isVerified = isVerified;
    }
}

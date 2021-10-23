package com.issuetracker.dto.auth;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class UserEmailDto {
    private String email;
    private Boolean primary;
    private Boolean verified;
    private String visibility;

    @JsonGetter("email")
    public String getEmail() {
        return email;
    }

    @JsonSetter("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonGetter("primary")
    public Boolean isPrimary() {
        return primary;
    }

    @JsonSetter("primary")
    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    @JsonGetter("verified")
    public Boolean isVerified() {
        return verified;
    }

    @JsonSetter("verified")
    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    @JsonGetter("visibility")
    public String getVisibility() {
        return visibility;
    }

    @JsonSetter("visibility")
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
}

package com.misc4.sha256.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PassAuthReqRespDto {

    @NotBlank(message = "user name cannot be null or empty")
    @Size(min = 1, message = "user name should have at least 1 character")
    private String userName;
    @NotBlank(message = "password cannot be null or empty")
    @Size(min = 1, message = "password should have at least 1 character")
    private String password;
    private String sha256Signature;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSha256Signature() {
        return sha256Signature;
    }

    public void setSha256Signature(String sha256Signature) {
        this.sha256Signature = sha256Signature;
    }
}

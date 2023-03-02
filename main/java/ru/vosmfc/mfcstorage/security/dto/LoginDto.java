package ru.vosmfc.mfcstorage.security.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LoginDto {

    @NotBlank
    @NotNull
    private String userName;

    @NotBlank
    @NotNull
    private String password;

    public LoginDto() {
    }

    public LoginDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

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

}

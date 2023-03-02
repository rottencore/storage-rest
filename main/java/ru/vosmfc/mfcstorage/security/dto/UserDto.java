package ru.vosmfc.mfcstorage.security.dto;

import ru.vosmfc.mfcstorage.security.domain.UserRole;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserDto {

    private Long id;

    @NotBlank
    @NotNull
    private String userName;

    @NotBlank
    @NotNull
    private String password;

    @NotBlank
    @NotNull
    private String firstName;

    private String surName;

    @NotBlank
    @NotNull
    private String lastName;

    @NotBlank
    @NotNull
    private String email;

    @NotNull
    private boolean isActive;

    @NotNull
    private UserRole userRole;

    public UserDto() {
    }

    public UserDto(Long id, String userName, String password, String firstName, String lastName, String email, boolean isActive, UserRole userRole) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isActive = isActive;
        this.userRole = userRole;
    }

    public UserDto(Long id, String userName, String password, String firstName, String surName, String lastName, String email, boolean isActive, UserRole userRole) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.surName = surName;
        this.lastName = lastName;
        this.email = email;
        this.isActive = isActive;
        this.userRole = userRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

}

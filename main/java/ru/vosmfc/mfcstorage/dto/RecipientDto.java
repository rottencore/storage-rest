package ru.vosmfc.mfcstorage.dto;

import ru.vosmfc.mfcstorage.domain.Department;
import ru.vosmfc.mfcstorage.domain.Position;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RecipientDto {

    private Long id;

    @NotBlank
    @NotNull
    private String lastName;

    @NotBlank
    @NotNull
    private String firstName;

    private String surName;

    @NotBlank
    @NotNull
    private String phoneNumber;

    @NotNull
    private Department department;

    @NotNull
    private Position position;

    public RecipientDto() {
    }

    public RecipientDto(Long id, String lastName, String firstName, String phoneNumber, Department department, Position position) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.position = position;
    }

    public RecipientDto(Long id, String lastName, String firstName, String surName, String phoneNumber, Department department, Position position) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.surName = surName;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}

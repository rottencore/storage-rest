package ru.vosmfc.mfcstorage.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DepartmentDto {

    private Long id;

    @NotBlank
    @NotNull
    private String departmentName;

    public DepartmentDto() {
    }

    public DepartmentDto(Long id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

}

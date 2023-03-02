package ru.vosmfc.mfcstorage.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PositionDto {

    private Long id;

    @NotBlank
    @NotNull
    private String positionName;

    public PositionDto() {
    }

    public PositionDto(Long id, String positionName) {
        this.id = id;
        this.positionName = positionName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

}

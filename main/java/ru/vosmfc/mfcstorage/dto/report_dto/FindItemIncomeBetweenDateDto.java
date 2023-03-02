package ru.vosmfc.mfcstorage.dto.report_dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FindItemIncomeBetweenDateDto {

    @NotBlank
    @NotNull
    private String startDate;

    @NotBlank
    @NotNull
    private String endDate;

    public FindItemIncomeBetweenDateDto() {
    }

    public FindItemIncomeBetweenDateDto(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

}

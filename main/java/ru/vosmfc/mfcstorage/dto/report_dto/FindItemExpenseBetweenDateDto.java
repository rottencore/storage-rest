package ru.vosmfc.mfcstorage.dto.report_dto;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;

public class FindItemExpenseBetweenDateDto {

    @NotBlank
    @NotNull
    private String startDate;

    @NotBlank
    @NotNull
    private String endDate;

    public FindItemExpenseBetweenDateDto() {
    }

    public FindItemExpenseBetweenDateDto(String startDate, String endDate) {
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

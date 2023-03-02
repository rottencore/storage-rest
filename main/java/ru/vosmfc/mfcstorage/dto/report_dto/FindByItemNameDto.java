package ru.vosmfc.mfcstorage.dto.report_dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FindByItemNameDto {

    @NotBlank
    @NotNull
    private String itemName;

    public FindByItemNameDto() {
    }

    public FindByItemNameDto(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

}

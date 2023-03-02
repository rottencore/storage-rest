package ru.vosmfc.mfcstorage.dto;

import ru.vosmfc.mfcstorage.domain.Storage;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ItemIncomeDto {

    private Long id;

    @NotNull
    private Storage storage;

    @Min(1)
    private Integer incomeQuantity;

    @NotBlank
    private String incomeDate;

    public ItemIncomeDto() {
    }

    public ItemIncomeDto(Long id, Storage storage, Integer incomeQuantity, String incomeDate) {
        this.id = id;
        this.storage = storage;
        this.incomeQuantity = incomeQuantity;
        this.incomeDate = incomeDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Integer getIncomeQuantity() {
        return incomeQuantity;
    }

    public void setIncomeQuantity(Integer incomeQuantity) {
        this.incomeQuantity = incomeQuantity;
    }

    public String getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(String incomeDate) {
        this.incomeDate = incomeDate;
    }

}

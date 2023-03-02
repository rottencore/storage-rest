package ru.vosmfc.mfcstorage.dto;

import ru.vosmfc.mfcstorage.domain.Recipient;
import ru.vosmfc.mfcstorage.domain.Storage;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ItemExpenseDto {

    private Long id;

    @NotNull
    private Storage storage;

    @NotNull
    private Recipient recipient;

    @Min(1)
    private Integer expenseQuantity;

    @NotBlank
    @NotNull
    private String expenseDate;

    public ItemExpenseDto() {
    }

    public ItemExpenseDto(Long id, Storage storage, Recipient recipient, Integer expenseQuantity, String expenseDate) {
        this.id = id;
        this.storage = storage;
        this.recipient = recipient;
        this.expenseQuantity = expenseQuantity;
        this.expenseDate = expenseDate;
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

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public Integer getExpenseQuantity() {
        return expenseQuantity;
    }

    public void setExpenseQuantity(Integer expenseQuantity) {
        this.expenseQuantity = expenseQuantity;
    }

    public String getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(String expenseDate) {
        this.expenseDate = expenseDate;
    }

}

package ru.vosmfc.mfcstorage.dto;

import ru.vosmfc.mfcstorage.domain.Item;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class StorageDto {

    private Long id;

    @NotNull
    private Item item;

    @Min(0)
    @NotNull
    private Integer quantity;

    public StorageDto() {
    }

    public StorageDto(Long id, Item item, Integer quantity) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}

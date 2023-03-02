package ru.vosmfc.mfcstorage.dto;

import ru.vosmfc.mfcstorage.domain.ItemCategory;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ItemDto {

    private Long id;

    @NotBlank
    @NotNull
    private String itemName;

    @NotNull
    private ItemCategory itemCategory;

    public ItemDto() {
    }

    public ItemDto(Long id, String itemName, ItemCategory itemCategory) {
        this.id = id;
        this.itemName = itemName;
        this.itemCategory = itemCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }

}

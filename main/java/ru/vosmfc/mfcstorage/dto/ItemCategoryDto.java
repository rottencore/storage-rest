package ru.vosmfc.mfcstorage.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ItemCategoryDto {

    private Long id;

    @NotBlank
    @NotNull
    private String categoryName;

    public ItemCategoryDto() {
    }

    public ItemCategoryDto(Long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}

package ru.vosmfc.mfcstorage.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name", unique = true, nullable = false)
    private String itemName;

    @ManyToOne
    @JoinColumn(name = "itemCategory")
    private ItemCategory itemCategory;

    @JsonIgnore
    @OneToOne(mappedBy = "item", cascade = CascadeType.ALL)
    private Storage storage;

    public Item(){
    }

    public Item(String itemName, ItemCategory itemCategory) {
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

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

}

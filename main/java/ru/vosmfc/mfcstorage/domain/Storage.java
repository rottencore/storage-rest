package ru.vosmfc.mfcstorage.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "storage")
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "item", nullable = false, unique = true)
    private Item item;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @JsonIgnore
    @OneToMany(mappedBy = "storage", cascade = CascadeType.ALL)
    private List<ItemExpense> itemExpenses;

    @JsonIgnore
    @OneToMany(mappedBy = "storage", cascade = CascadeType.ALL)
    private List<ItemIncome> itemIncomes;

    public Storage() {
    }

    public Storage(Item item, Integer quantity) {
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

    public List<ItemExpense> getItemExpenses() {
        return itemExpenses;
    }

    public void setItemExpenses(List<ItemExpense> itemExpenses) {
        this.itemExpenses = itemExpenses;
    }

    public List<ItemIncome> getItemIncomes() {
        return itemIncomes;
    }

    public void setItemIncomes(List<ItemIncome> itemIncomes) {
        this.itemIncomes = itemIncomes;
    }

}

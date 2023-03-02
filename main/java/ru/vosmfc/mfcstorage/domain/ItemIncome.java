package ru.vosmfc.mfcstorage.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "item_incomes")
public class ItemIncome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "storage")
    private Storage storage;

    @Column(name = "income_quantity", nullable = false)
    private Integer incomeQuantity;

    @Column(name = "income_date", nullable = false)
    private LocalDate incomeDate;

    public ItemIncome() {
    }

    public ItemIncome(Storage storage, Integer incomeQuantity, LocalDate incomeDate) {
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

    public LocalDate getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(LocalDate incomeData) {
        this.incomeDate = incomeData;
    }

}

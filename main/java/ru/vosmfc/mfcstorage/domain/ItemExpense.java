package ru.vosmfc.mfcstorage.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "item_expenses")
public class ItemExpense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "storage")
    private Storage storage;

    @ManyToOne
    @JoinColumn(name = "recipient")
    private Recipient recipient;

    @Column(name = "expense_quantity", nullable = false)
    private Integer expenseQuantity;

    @Column(name = "expense_date", nullable = false)
    private LocalDate expenseDate;

    public ItemExpense() {
    }

    public ItemExpense(Storage storage, Recipient recipient, Integer expenseQuantity, LocalDate expenseDate) {
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

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

}

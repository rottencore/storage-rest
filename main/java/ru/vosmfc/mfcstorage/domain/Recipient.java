package ru.vosmfc.mfcstorage.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "recipients")
public class Recipient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "surname")
    private String surName;

    @Column(name = "phone_number", unique = true, nullable = false)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "position")
    private Position position;

    @JsonIgnore
    @OneToMany(mappedBy = "recipient", cascade = CascadeType.ALL)
    List<ItemExpense> itemExpenses;

    public Recipient() {
    }

    public Recipient(String lastName, String firstName, String phoneNumber, Department department, Position position) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.position = position;
    }

    public Recipient(String lastName, String firstName, String surName, String phoneNumber, Department department, Position position) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.surName = surName;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<ItemExpense> getItemExpenses() {
        return itemExpenses;
    }

    public void setItemExpenses(List<ItemExpense> itemExpenses) {
        this.itemExpenses = itemExpenses;
    }

}

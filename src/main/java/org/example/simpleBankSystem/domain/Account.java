package org.example.simpleBankSystem.domain;

import javax.persistence.*;

@Entity
@Table(name = "account")
//@Transactional
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "number")
    private Integer number;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "currency")
    private String currency;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User owner;

    public Account() {
    }

    public Account(Integer number, Double balance, String currency, User owner) {
        this.number = number;
        this.balance = balance;
        this.currency = currency;
        this.owner = owner;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}

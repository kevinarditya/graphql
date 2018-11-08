package com.btpn.chips.mskevingraphql.kafka.model;

public class UserCreationModel {
    private String name;
    private Long balance;

    public UserCreationModel() {
    }

    public UserCreationModel(String name, Long balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}

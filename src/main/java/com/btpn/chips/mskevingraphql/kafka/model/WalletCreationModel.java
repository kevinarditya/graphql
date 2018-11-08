package com.btpn.chips.mskevingraphql.kafka.model;

public class WalletCreationModel {
    private int idUser;
    private int idWallet;
    private String name;
    private long balance;

    public WalletCreationModel() {
    }

    public WalletCreationModel(int idUser, int idWallet, String name, long balance) {
        this.idUser = idUser;
        this.idWallet = idWallet;
        this.name = name;
        this.balance = balance;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdWallet() {
        return idWallet;
    }

    public void setIdWallet(int idWallet) {
        this.idWallet = idWallet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "WalletCreationModel{" +
                "idUser=" + idUser +
                ", idWallet=" + idWallet +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}

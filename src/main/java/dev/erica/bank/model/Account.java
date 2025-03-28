package dev.erica.bank.model;

public abstract class Account {
    protected float balance;

    public Account(float initialBalance) {
        this.balance = initialBalance;
    }

    public float getBalance() { return balance; }
}

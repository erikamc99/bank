package dev.erica.bank.model;

public abstract class Account {
    protected float balance;
    protected float annualRate;

    public Account(float initialBalance, float annualRate) {
        this.balance = initialBalance;
        this.annualRate = annualRate;
    }

    public float getBalance() { return balance; }
    public float getAnnualRate() { return annualRate; }
}

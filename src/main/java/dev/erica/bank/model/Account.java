package dev.erica.bank.model;

public abstract class Account {
    protected float balance;
    protected float annualRate;
    protected int totalDeposits;

    public Account(float initialBalance, float annualRate) {
        this.balance = initialBalance;
        this.annualRate = annualRate;
        this.totalDeposits = 0;
    }

    public float getBalance() { return balance; }
    public float getAnnualRate() { return annualRate; }
    public int getTotalDeposits() { return totalDeposits; }
}

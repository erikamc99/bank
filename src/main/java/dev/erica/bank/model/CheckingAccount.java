package dev.erica.bank.model;

public class CheckingAccount extends Account {

    protected float overdraft;

    public CheckingAccount(float initialBalance, float annualRate, float overdraft) {
        super(initialBalance, annualRate);
        this.overdraft = overdraft;
    }

    public float getOverdraft() { return overdraft; }

}

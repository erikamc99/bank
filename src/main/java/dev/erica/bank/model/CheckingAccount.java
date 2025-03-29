package dev.erica.bank.model;

public class CheckingAccount extends Account {

    protected float overdraft;

    public CheckingAccount(float initialBalance, float annualRate, float overdraft) {
        super(initialBalance, annualRate);
        this.overdraft = overdraft;
    }

    public float getOverdraft() { return overdraft; }

    @Override
    public void deposit(float quantity) {
        if(overdraft > 0) {
            float newOverdraft = Math.min(quantity, overdraft);
            overdraft -= newOverdraft;
            balance += (quantity - newOverdraft);
        } else { super.deposit(quantity); }
    }

}

package dev.erica.bank.model;

public abstract class Account {
    protected float balance;
    protected float annualRate;
    protected int totalDeposits;
    protected int totalWithdraws;
    protected float monthlyCommission;


    public Account(float initialBalance, float annualRate) {
        this.balance = initialBalance;
        this.annualRate = annualRate;
        this.totalDeposits = 0;
        this.totalWithdraws = 0;
        this.monthlyCommission = 0.0f;
    }

    public float getBalance() { return balance; }
    public float getAnnualRate() { return annualRate; }
    public int getTotalDeposits() { return totalDeposits; }
    public int getTotalWithdraws() { return totalWithdraws; }
    public float getMonthlyCommission() { return monthlyCommission; }

    public void deposit(float quantity) {
        balance += quantity;
        totalDeposits++;
    }

    public void withdraw(float quantity) {
        if(balance < quantity ) throw new RuntimeException("No tiene saldo suficiente.");
        balance -= quantity;
        totalWithdraws++;
    }

    protected float calculateMonthlyInterest() {
        float monthlyInterest = (balance * annualRate) / 12;
        balance += monthlyInterest;
        return monthlyInterest;
    }

    public void monthlyStatement() {
        calculateMonthlyInterest();
        balance -= monthlyCommission;
    }
}

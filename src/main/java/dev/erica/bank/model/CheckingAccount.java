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

    @Override
    public void withdraw(float quantity) {
        if(quantity > balance) {
            float deficit = quantity - balance;
            overdraft += deficit;
            balance = 0;
        } else { super.withdraw(quantity); }
    }

    @Override
    public void monthlyStatement() {
        super.monthlyStatement();
    }

    @Override
    public String printTicket() {
        return "Su saldo es de " + balance + "€/n" 
              + "Su comisión mensual es de " + monthlyCommission + "€/n" 
              + "Su sobregiro es de " + overdraft + "€/n"
              + "Transacciones realizadas: " + (totalDeposits + totalWithdraws);
    }
}

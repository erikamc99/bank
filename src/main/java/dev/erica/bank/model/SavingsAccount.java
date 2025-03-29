package dev.erica.bank.model;

public class SavingsAccount extends Account {
    
    protected boolean isActive = false;

    public SavingsAccount(float initialBalance, float annualRate) {
        super(initialBalance, annualRate);
        updateState();
    }

    protected void updateState() {
        isActive = balance >= 10000;
    }

    @Override
    public void deposit(float quantity) {
        if(isActive || quantity >= 10000 - balance) {
            super.deposit(quantity);
            updateState();
        }
    }

    @Override
    public void withdraw(float quantity) {
        if(isActive && quantity <= balance) {
            super.withdraw(quantity);
            updateState();
        }
    }

    @Override
    public void monthlyStatement() {
        if (totalWithdraws > 4) {
            monthlyCommission = (totalWithdraws - 4) * 1000;
        } else {
            monthlyCommission = 0; 
        }
    
        super.monthlyStatement();
    
        updateState();
    }

    @Override
    public String printTicket() {
        if(isActive == false) {
            return "Cuenta inactiva. Su saldo es de " + balance + "€/n";
        } else {
            return "Su saldo es de " + balance + "€/n" 
            + "Su comisión mensual es de " + monthlyCommission + "€/n" 
            + "Transacciones realizadas: " + (totalDeposits + totalWithdraws);
        }       
    }
}
package dev.erica.bank.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AccountTest {
    
    public static class TestAccount extends Account {

        public TestAccount(float initialBalance, float annualRate){
            super(initialBalance, annualRate);
        }

        @Override
        public void deposit(float quantity) {
            super.deposit(quantity);
        }

        @Override
        public void withdraw(float quantity) {
            super.withdraw(quantity); 
        }

        @Override
        protected float calculateMonthlyInterest() {
            return super.calculateMonthlyInterest();
        }

        @Override
        public void monthlyStatement() {
            super.monthlyStatement();
        }

        @Override
        public String printTicket() {

            String ticket = "Su saldo es de " + balance + "€";
            return ticket;
        }
    }

    private TestAccount account;

    @BeforeEach
    void setUp() {
        account = new TestAccount(100, 0.05f);
    }

    @Test
    @DisplayName("Test para comprobar el atributo de saldo inicial")
    public void initialBalanceTest() {

        assertEquals(100, account.getBalance());
    }

    @Test
    @DisplayName("Test para comprobar la tasa anual inicial")
    public void annualRateTest() {

        assertEquals(0.05f, account.getAnnualRate());
    }

    @Test
    @DisplayName("Test para comprobar el total de consignaciones inicial")
    public void totalDepositsTest() {

        assertEquals(0, account.getTotalDeposits());
    }

    @Test
    @DisplayName("Test para comprobar el total de retiros inicial")
    public void totalWithdrawsTest() {

        assertEquals(0, account.getTotalWithdraws());
    }

    @Test
    @DisplayName("Test para comprobar la comisión mensual inicial")
    public void monthlyCommissionTest() {

        assertEquals(0, account.getMonthlyCommission());
    }

    @Test
    @DisplayName("Test para comprobar la consignación")
    public void depositTest() {
        account.deposit(500);

        assertEquals(600, account.getBalance());
        assertEquals(1, account.getTotalDeposits());
    }

    @Test
    @DisplayName("Test para comprobar la retirada de dinero")
    public void withdrawTest() {
        account.withdraw(50);

        assertEquals(50, account.getBalance());
        assertEquals(1, account.getTotalWithdraws());
    }

    @Test
    @DisplayName("Test para comprobar el cálculo de interés mensual")
    public void monthlyInterestTest() {
        account.deposit(400);
        float interest = account.calculateMonthlyInterest();

        assertEquals(2.0833333f, interest);
        assertEquals(502.0833333f, account.getBalance());
    }

    @Test
    @DisplayName("Test para comprobar el extracto mensual")
    public void monthlyStatementTest() {
        account.deposit(400);
        account.monthlyCommission = 2.0833333f;

        account.monthlyStatement();

        assertEquals(500.0f, account.getBalance());
    }

    @Test
    @DisplayName("Test para comprobar la impresión de un ticket")
    public void printTicketTest() {
        assertEquals("Su saldo es de 100.0€", account.printTicket());
    }
}
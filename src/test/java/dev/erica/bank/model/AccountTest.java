package dev.erica.bank.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
            balance += quantity;
            totalDeposits++;
        }

        @Override
        public void withdraw(float quantity) {
            if (balance < quantity) throw new RuntimeException("No tiene saldo suficiente.");

            balance -= quantity;
            totalWithdraws++; 
        }
    }

    private TestAccount account;

    @BeforeEach
    void setUp() {
        account = new TestAccount(100, 0.5f);
    }

    @Test
    @DisplayName("Test para comprobar el atributo de saldo inicial")
    public void initialBalanceTest() {

        assertEquals(100, account.getBalance());
    }

    @Test
    @DisplayName("Test para comprobar la tasa anual inicial")
    public void annualRateTest() {

        assertEquals(0.5f, account.getAnnualRate());
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
    @DisplayName("Test para comprobar la excepción de la retirada de dinero")
    public void withdrawExceptionTest() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> account.withdraw(200.0f));
        assertEquals("No tiene saldo suficiente.", exception.getMessage());
    }
}

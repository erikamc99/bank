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
    @DisplayName("Test para comprobar la tasa anual")
    public void annualRateTest() {

        assertEquals(0.5f, account.getAnnualRate());
    }

    @Test
    @DisplayName("Test para comprobar el total de consignaciones")
    public void totalDepositsTest() {

        assertEquals(0, account.getTotalDeposits());
    }

    @Test
    @DisplayName("Test para comprobar el total de retiros")
    public void totalWithdrawsTest() {

        assertEquals(0, account.getTotalWithdraws());
    }
}

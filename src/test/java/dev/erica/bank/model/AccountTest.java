package dev.erica.bank.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AccountTest {
    
    public static class TestAccount extends Account {

        public TestAccount(float initialBalance, float annualRate){
            super(initialBalance, annualRate);
        }
    }

    private TestAccount account;

    @Test
    @DisplayName("Test para comprobar el atributo de saldo inicial")
    public void initialBalanceTest() {

        account = new TestAccount(100);

        assertEquals(100, account.getBalance());
    }

    @Test
    @DisplayName("Test para comprobar la tasa anual")
    public void annualRateTest() {
        account = new TestAccount(100, 0.5f);

        assertEquals(0.5f, account.getAnnualRate());
    }
}

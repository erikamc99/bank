package dev.erica.bank.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AccountTest {
    
    public static class TestAccount extends Account {

        public TestAccount(float initialBalance){
            super(initialBalance);
        }
    }

    private TestAccount account;

    @Test
    @DisplayName("Test para comprobar el atributo de saldo inicial")
    public void initialBalanceTest() {

        account = new TestAccount(100);

        assertEquals(100, account.getBalance());
    }
}

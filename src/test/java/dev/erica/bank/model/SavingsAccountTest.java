package dev.erica.bank.model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {

    private SavingsAccount account;

    @Test
    @DisplayName("Test para comprobar si está activa la cuenta")
    public void isActiveTest() {
        account = new SavingsAccount(50000, 0.05f);
        assertTrue(account.isActive);
    }
}

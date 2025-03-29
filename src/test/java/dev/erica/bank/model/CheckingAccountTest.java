package dev.erica.bank.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckingAccountTest {

    private CheckingAccount account;

    @Test
    @DisplayName("Test para comprobar el sobregiro")
    public void overdraftTest() {
        account = new CheckingAccount(5000, 0.05f);
        
        assertEquals(0, account.getOverdraft());
    }
}

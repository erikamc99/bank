package dev.erica.bank.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

    @Test
    @DisplayName("Test para comprobar si no está activa la cuenta")
    public void isNotActiveTest() {
        account = new SavingsAccount(5000, 0.05f);
        assertFalse(account.isActive);
    }

    @Test
    @DisplayName("Test para comprobar la consignación")
    public void depositTest() {
        account = new SavingsAccount(5000, 0.05f);
        account.deposit(5000);
        
        assertTrue(account.isActive);
        assertEquals(10000, account.getBalance());
    }

    @Test
    @DisplayName("Test para comprobar la consignación")
    public void depositErrorTest() {
        account = new SavingsAccount(5000, 0.05f);
        account.deposit(500);
        
        assertFalse(account.isActive);
        assertEquals(5000, account.getBalance());
    }
}
package dev.erica.bank.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {

    private SavingsAccount accountT;
    private SavingsAccount accountF;


    @BeforeEach
    void setUp() {
        accountT = new SavingsAccount(50000, 0.05f);
        accountF = new SavingsAccount(5000, 0.05f);
    }

    @Test
    @DisplayName("Test para comprobar si está activa la cuenta")
    public void isActiveTest() {
        assertTrue(accountT.isActive);
    }

    @Test
    @DisplayName("Test para comprobar si no está activa la cuenta")
    public void isNotActiveTest() {
        assertFalse(accountF.isActive);
    }

    @Test
    @DisplayName("Test para comprobar la consignación")
    public void depositTest() {
        accountF.deposit(5000);
        
        assertTrue(accountF.isActive);
        assertEquals(10000, accountF.getBalance());
    }

    @Test
    @DisplayName("Test para comprobar la consignación en una cuenta inactiva")
    public void depositErrorTest() {
        accountF.deposit(500);
        
        assertFalse(accountF.isActive);
        assertEquals(5000, accountF.getBalance());
    }

    @Test
    @DisplayName("Test para comprobar la retirada de dinero en una cuenta activa")
    public void withdrawTest() {
        accountT.withdraw(40000);

        assertEquals(10000, accountT.getBalance());
    }

    @Test
    @DisplayName("Test para comprobar la retirada de dinero en una cuenta inactiva")
    public void withdrawErrorTest() {
        accountF.withdraw(10000);

        assertEquals(5000, accountF.getBalance());
    }

    @Test
    @DisplayName("Test para comprobar la retirada de dinero en una cuenta inactiva")
    public void withdrawError2Test() {
        accountT.withdraw(100000);

        assertEquals(5000, accountF.getBalance());
    }
}
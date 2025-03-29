package dev.erica.bank.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckingAccountTest {

    private CheckingAccount account;
    private CheckingAccount accountO;

    @BeforeEach
    void setUp() {
        account = new CheckingAccount(5000, 0.05f, 0);
        accountO = new CheckingAccount(5000, 0.05f, 1000);
    }

    @Test
    @DisplayName("Test para comprobar el sobregiro")
    public void overdraftTest() {
        accountO.getOverdraft();
        assertEquals(1000, accountO.getOverdraft());
    }

    @Test
    @DisplayName("Test para comprobar el ingreso de dinero con sobregiro")
    public void depositTest() {
        accountO.deposit(5000);

        assertEquals(9000, accountO.getBalance());
    }

    @Test
    @DisplayName("Test para comprobar el ingreso de dinero sin sobregiro")
    public void depositWithoutOverdraftTest() {
        account.deposit(5000);

        assertEquals(10000, account.getBalance());
    }

    @Test
    @DisplayName("Test para comprobar el ingreso de dinero con sobregiro")
    public void withdrawTest() {
        account.withdraw(6000);

        assertEquals(1000, account.getOverdraft());
        assertEquals(0, account.getBalance());
    }

    @Test
    @DisplayName("Test para comprobar el ingreso de dinero con sobregiro")
    public void withdrawVithoutOverdraftTest() {
        account.withdraw(1000);

        assertEquals(4000, account.getBalance());
    }
} 

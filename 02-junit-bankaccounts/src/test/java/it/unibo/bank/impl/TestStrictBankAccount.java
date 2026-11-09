package it.unibo.bank.impl;

import it.unibo.bank.api.AccountHolder;
import it.unibo.bank.api.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail; //metodo di JUnit che serve a far fallire volontariamente un test (non usato).
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for the {@link StrictBankAccount} class.
 */
class TestStrictBankAccount {

    // Create a new AccountHolder and a StrictBankAccount for it each time tests are executed.
    private AccountHolder mRossi;
    private BankAccount bankAccount;

    /**
     * Prepare the tests.
     */
    @BeforeEach // @BeforeEach indica a JUnit di eseguire setUp() prima di ogni singolo test.
    public void setUp() {
        this.mRossi = new AccountHolder("Mario", "Rossi", 1); //crea il titolare
        this.bankAccount = new StrictBankAccount(mRossi, 0.0); //crea un nuovo conto con saldo = 0
    }

    /**
     * Test the initial state of the StrictBankAccount.
     */
    @Test
    public void testInitialization() {
        assertEquals(0.0, bankAccount.getBalance()); // assertEquals() serve a verificare che due valori siano uguali.
        assertEquals(0, bankAccount.getTransactionsCount()); 
        assertEquals(mRossi, bankAccount.getAccountHolder());
    }

    /**
     * Perform a deposit of 100€, compute the management fees, and check that the balance is correctly reduced.
     */
    @Test
    public void testManagementFees() {
        bankAccount.deposit(mRossi.getUserID(), 100); //deposita 100 euro 
        bankAccount.chargeManagementFees(mRossi.getUserID()); //applica la commissione
        assertEquals(94.90, bankAccount.getBalance());
    }

    /**
     * Test that withdrawing a negative amount causes a failure.
     */
    @Test
    public void testNegativeWithdraw() { //assertThrows fa scattare una eccezione (errore).
        assertThrows(IllegalArgumentException.class, () -> { //Il numero negativo fa scattare IllegalArgumentException nel metodo withdraw().
            bankAccount.withdraw(mRossi.getUserID(), -50); //se si inserisce un numero negativo il test passa e genera errore perchè non è possibile prelevare un numero negativo.
        });
    }

    /**
     * Verifica che non sia consentito prelevare una somma superiore al saldo disponibile sul conto.
     */
    @Test
    public void testWithdrawingTooMuch() {
        bankAccount.deposit(mRossi.getUserID(), 100); //deposita 100 euro 
        assertThrows(IllegalArgumentException.class, () -> { 
            bankAccount.withdraw(mRossi.getUserID(), 150); //prova a prelevare 150 euro e fa scattare IllegalArgumentException nel metodo withdraw().
        });
        assertEquals(100, bankAccount.getBalance()); //infine dopo il prelievo rifiutato controlla che il saldo sia ancora 100.
    }
}

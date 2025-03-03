package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class BankAccountTest {

    protected BankAccount account;

    public final int initialState;
    public final int initialDeposit;
    public final int initialWithdraw;
    public final int expectedAfterWithdraw;


    public BankAccountTest(int initialState, int initialDeposit, int initialWithdraw, int expectedAfterWithdraw) {
        this.initialState = initialState;
        this.initialDeposit = initialDeposit;
        this.initialWithdraw = initialWithdraw;
        this.expectedAfterWithdraw = expectedAfterWithdraw;
    }

    @BeforeEach
    protected abstract void init();

    @Test
    public void testInitiallyEmpty() {
        assertEquals(initialState, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(initialDeposit);
        assertEquals(initialDeposit, this.account.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(initialDeposit);
        this.account.withdraw(initialWithdraw);
        assertEquals(expectedAfterWithdraw, this.account.getBalance());
    }

}

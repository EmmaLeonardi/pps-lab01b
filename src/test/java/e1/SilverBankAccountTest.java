package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends BankAccountTest {

    public static final int INITIAL_STATE = 0;
    public static final int INITIAL_DEPOSIT = 1000;
    public static final int INITIAL_WITHDRAW = 100;
    public static final int FEE = 1;
    public static final int EXPECTED_AFTER_WITHDRAW = INITIAL_DEPOSIT - INITIAL_WITHDRAW - FEE;

    public SilverBankAccountTest() {
        super(INITIAL_STATE, INITIAL_DEPOSIT, INITIAL_WITHDRAW, EXPECTED_AFTER_WITHDRAW);
    }

    @Override
    @BeforeEach
    protected void init() {
        this.account = new SilverBankAccount(new CoreBankAccount());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable() {
        this.account.deposit(INITIAL_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(INITIAL_DEPOSIT * 2));
    }

}

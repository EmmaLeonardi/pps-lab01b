package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BronzeBankAccountTest extends BankAccountTest{

    public static final int INITIAL_STATE =0;
    public static final int INITIAL_DEPOSIT=1000;
    public static final int INITIAL_WITHDRAW=99;
    public static final int EXPECTED_AFTER_WITHDRAW=INITIAL_DEPOSIT-INITIAL_WITHDRAW;
    public static final int WITHDRAW_WITH_FEE=150;
    public static final int FEE=1;

    public BronzeBankAccountTest() {
        super(INITIAL_STATE, INITIAL_DEPOSIT, INITIAL_WITHDRAW, EXPECTED_AFTER_WITHDRAW);
    }

    @Override
    @BeforeEach
    protected void init(){
        this.account = new BronzeBankAccount(new CoreBankAccount());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable() {
        this.account.deposit(INITIAL_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(INITIAL_DEPOSIT * 2));
    }

    @Test
    public void testWithdrawWithFee(){
        this.account.deposit(INITIAL_DEPOSIT);
        this.account.withdraw(WITHDRAW_WITH_FEE);
        assertEquals(INITIAL_DEPOSIT-WITHDRAW_WITH_FEE-FEE, this.account.getBalance());

    }

}

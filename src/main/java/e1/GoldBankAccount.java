package e1;

public class GoldBankAccount extends DecoratorBankAccount implements BankAccount {

    private final int maxOverdraftAllowed=500;

    public GoldBankAccount(BankAccount b) {
        super(b);
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance()+maxOverdraftAllowed < amount){
            throw new IllegalStateException("In a Gold bank account up to -500 overdraft is allowed");
        }
        super.withdraw(amount);
    }
}

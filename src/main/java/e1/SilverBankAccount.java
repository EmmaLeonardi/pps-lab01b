package e1;

public class SilverBankAccount extends DecoratorBankAccount implements BankAccount {

    private final int fee=1;

    public SilverBankAccount(BankAccount b){
        super(b);
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException("In a Silver bank account no overdraft is allowed");
        }
        super.withdraw(amount + fee);
    }
}

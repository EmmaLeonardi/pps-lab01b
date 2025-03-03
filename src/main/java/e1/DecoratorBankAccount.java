package e1;

public class DecoratorBankAccount implements BankAccount{

    private final BankAccount bankAccount;

    protected DecoratorBankAccount(final BankAccount b){
        this.bankAccount=b;
    }

    @Override
    public int getBalance() {
        return this.bankAccount.getBalance();
    }

    @Override
    public void deposit(int amount) {
        this.bankAccount.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        this.bankAccount.withdraw(amount);
    }
}

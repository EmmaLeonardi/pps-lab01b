package e1;

public class BronzeBankAccount extends DecoratorBankAccount implements BankAccount {

    private final int fee=1;
    private final int maxWithdrawWithoutFee=100;

    public BronzeBankAccount(BankAccount b){
        super(b);
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException("In a Bronze bank account no overdraft is allowed");
        }
        if(amount<maxWithdrawWithoutFee){
            super.withdraw(amount);
        }else{
            super.withdraw(amount + fee);
        }
    }
}

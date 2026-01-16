public abstract class AccountDecorator extends Account {
    protected Account wrappedAccount;

    public AccountDecorator(Account account) {
        super(account.getAccountId());
        this.wrappedAccount = account;
    }

    @Override
    public double getBalance() {
        return wrappedAccount.getBalance();
    }

    @Override
    public void credit(double amount) {
        wrappedAccount.credit(amount);
    }

    @Override
    public void debit(double amount) {
        wrappedAccount.debit(amount);
    }
}

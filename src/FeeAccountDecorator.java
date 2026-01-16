public abstract class FeeAccountDecorator extends AccountDecorator{
    public FeeAccountDecorator(Account account) {
        super(account);
    }

    @Override
    public void debit(double amount) {
        double fee = wrappedAccount.calculateFee(amount);
        wrappedAccount.debit(amount + fee);
    }

    @Override
    public double calculateFee(double amount) {
        return wrappedAccount.calculateFee(amount);
    }

}

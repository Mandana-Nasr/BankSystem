public class TransactionAccount extends Account {
    private static final double WITHDRAW_FEE = 5.0;

    public TransactionAccount(String accountId) {
        super(accountId);
    }

    public void withdraw(double amount) {

        double total = amount + WITHDRAW_FEE;

        if (balance >= total) {
            balance -= total;
        } else {
            throw new IllegalArgumentException("Otillräckligt saldo (inklusive avgift)");
        }
    }

    @Override
    public double calculateFee(double amount) {
        return amount * 0.01; // 1 % avgift
    }

}

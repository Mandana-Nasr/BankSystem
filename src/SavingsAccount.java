public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountId, double interestRate) {
        super(accountId);
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        return balance * interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Otillräckligt saldo");
        }
    }

    @Override
    public double calculateFee(double amount) {
        return 0.0; // inga avgifter på sparkonto
    }

}

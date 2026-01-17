public class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.02; // 2 %

    public SavingsAccount(String accountId) {
        super(accountId);
        //this.accountId = accountId;

        this.balance = 0;
    }

//    public double calculateInterest() {
//        return balance * interestRate;
//    }

//    @Override
//    public void withdraw(double amount) {
//        if (balance >= amount) {
//            balance -= amount;
//            addTransaction("Uttag", amount);
//        } else {
//            throw new IllegalArgumentException("Otillräckligt saldo");
//        }
//    }

//    public void applyInterest() {
//        double interest = balance * interestRate;
//        balance += interest;
//        addTransaction("Ränta", interest);
//    }


    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Belopp måste vara större än 0");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("Otillräckligt saldo");
        }

        balance -= amount;
    }

    public double applyInterest() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        return interest;
    }


    @Override
    public double calculateFee(double amount) {
        return 0.0; // inga avgifter på sparkonto
    }

}

public class TransactionAccount extends Account {
    private static final double WITHDRAW_FEE = 5.0;

    public TransactionAccount(String accountId) {
        super(accountId);
    }


    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Belopp måste vara större än 0");
        }

        double fee = calculateFee(amount);
        double total = amount + fee;

//        if (balance >= total) {
//            balance -= total;
//
//            addTransaction(new Transaction(accountId, amount, "WITHDRAW"));
//            addTransaction(new Transaction(accountId,amount,"FEE"));
//        } else {
//            throw new IllegalArgumentException(
//                    "Otillräckligt saldo (inklusive avgift)"
//            );
//        }

        if (total > balance) {
            throw new IllegalArgumentException(
                    "Otillräckligt saldo (inklusive avgift)"
            );
        }

        balance -= total;

    }

    @Override
    public double calculateFee(double amount) {
        return amount * 0.01; // 1 % avgift
    }
}


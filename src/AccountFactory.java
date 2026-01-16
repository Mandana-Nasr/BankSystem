public class AccountFactory {
    public Account createAccount(String type, String accountId) {
        switch (type.toLowerCase()) {
            case "savings":
                return new SavingsAccount(accountId, 0.02);
            case "transaction":
                return new TransactionAccount(accountId);
            default:
                throw new IllegalArgumentException("Unknown account type");
        }
    }
}

import java.util.*;

public class BankRepository {
    private static BankRepository instance;

    private List<Account> accounts;
    //private List<Transaction> transactions;

    private BankRepository() {
        accounts = new ArrayList<>();
        //transactions = new ArrayList<>();
    }

    public static BankRepository getInstance() {
        if (instance == null) {
            instance = new BankRepository();
        }
        return instance;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account getAccount(String accountId) {
        return accounts.stream()
                .filter(a -> a.getAccountId().equals(accountId))
                .findFirst()
                .orElse(null);
    }

//    public void addTransaction(Transaction transaction) {
//        transactions.add(transaction);
//    }
//
//    public List<Transaction> getTransactions() {
//        return transactions;
//    }
}

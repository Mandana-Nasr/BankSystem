public class BankFacade {

    private AccountFactory accountFactory;
    private TransactionFactory transactionFactory;
    private BankRepository repository;
    private Account currentAccount;

    public BankFacade() {
        accountFactory = new AccountFactory();
        transactionFactory = new TransactionFactory();
        repository = BankRepository.getInstance();
    }

    public Account createAccount(String type, String accountId) {
        Account account = accountFactory.createAccount(type, accountId);
        repository.addAccount(account);
        return account;
    }

    public boolean login(String accountId) {
        currentAccount = repository.getAccount(accountId);
        return currentAccount != null;
    }

    public void logout() {
        currentAccount = null;
    }

    public double getBalance() {
        return currentAccount.getBalance();
    }

    public void deposit(double amount) {
        currentAccount.credit(amount);
        repository.addTransaction(
                transactionFactory.createTransaction("DEPOSIT", amount)
        );
    }

    public void withdraw(double amount) {
        currentAccount.debit(amount);
        repository.addTransaction(
                transactionFactory.createTransaction("WITHDRAW", amount)
        );
    }
    
}

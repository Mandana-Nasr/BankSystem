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

        Transaction t=transactionFactory.createTransaction("DEPOSIT", amount);
        currentAccount.addTransaction(t);
    }

    public void withdraw(double amount) {
        double before = currentAccount.getBalance();
        currentAccount.debit(amount);

        double after = currentAccount.getBalance();
        double fee=before-after-amount;

        currentAccount.addTransaction(transactionFactory.createTransaction("WITHDRAW", amount));

        if(fee>0) {
            currentAccount.addTransaction(transactionFactory.createTransaction("FEE",fee));

        }

//        Transaction t= transactionFactory.createTransaction("WITHDRAW", amount);
//        currentAccount.addTransaction(t);
    }

    public void showTransactionHistory() {
        if (currentAccount == null) {
            throw new IllegalStateException("Ingen användare inloggad");
        }

        if (currentAccount.getTransactions().isEmpty()) {
            System.out.println("Inga transaktioner att visa.");
            return;
        }

        for (Transaction t : currentAccount.getTransactions()) {
            System.out.println(t);
        }
    }

    public void applyInterest() {
//        if (currentAccount instanceof SavingsAccount savings) {
//            double before = savings.getBalance();
//
//            savings.applyInterest();
//
//            double interest = savings.getBalance() - before;
//
//            Transaction t =
//                    transactionFactory.createTransaction("INTEREST", interest);
//
//            currentAccount.addTransaction(t);
//        } else {
//            throw new IllegalStateException("Ränta gäller endast sparkonto");
//        }

        if (!(currentAccount instanceof SavingsAccount savings)) {
            throw new IllegalStateException("Ränta gäller endast sparkonto");
        }

        double interest = savings.applyInterest();

        currentAccount.addTransaction(
                transactionFactory.createTransaction("INTEREST", interest)
        );
    }

}

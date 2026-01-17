
import java.util.ArrayList;
import java.util.List;


public abstract class Account {
    protected String accountId;
    protected double balance;
    protected List<Transaction> transactions = new ArrayList<>();


    public Account(String accountId) {
        this.accountId = accountId;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void withdraw(double amount);

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Belopp måste vara större än 0");
        }
        balance += amount;
        //transactions.add(new Transaction(accountId,amount,"Insättning"));
    }

    public void credit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void debit(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        }
    }

//    protected void addTransaction(String type, double amount) {
//        transactions.add(new Transaction(accountId,amount, type));
//    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }



    // Polymorf metod
    public abstract double calculateFee(double amount);

}

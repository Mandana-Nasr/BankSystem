public abstract class Account {
    protected String accountId;
    protected double balance;

    public Account(String accountId) {
        this.accountId = accountId;
        this.balance = 0.0;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void withdraw(double amount);

    public void deposit(double amount) {
        balance += amount;
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

    // Polymorf metod
    public abstract double calculateFee(double amount);

}

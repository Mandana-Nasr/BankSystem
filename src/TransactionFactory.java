import java.util.UUID;

public class TransactionFactory {

    public Transaction createTransaction(String type, double amount) {
        return new Transaction(
                UUID.randomUUID().toString(),
                amount,
                type
        );
    }
}

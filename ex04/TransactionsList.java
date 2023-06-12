import java.util.UUID;

public interface TransactionsList {
    void addTransaction(Transaction transaction);
    public void removeTransaction(UUID transactionId) throws TransactionsLinkedList.TransactionNotFoundException;
    Transaction[] toArray();
}

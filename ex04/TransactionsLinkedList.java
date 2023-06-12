import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {
    Node head;

    @Override
    public void addTransaction(Transaction transaction) {
        Node newNode = new Node(transaction);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null)
            last = last.next;
        last.next = newNode;
        newNode.prev = last;

    }

    @Override
    public void removeTransaction(UUID transactionId) throws TransactionNotFoundException {
        Node temp = head;
        while (temp != null) {
            if (temp.data.getID() == transactionId) {
                if (temp.prev == null) {
                    head = temp.next;
                    head.prev = null;
                    return;
                }
                if (temp.next == null) {
                    temp.prev.next = null;
                    return;
                }
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                return;
            }
            temp = temp.next;
        }
        throw new TransactionNotFoundException("Transaction with ID " + transactionId + " not found");
    }

    @Override
    public Transaction[] toArray() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        Transaction[] transactions = new Transaction[count];
        temp = head;
        for (int i = 0; i < count; i++) {
            transactions[i] = temp.data;
            temp = temp.next;
        }
        return transactions;
    }

    static class Node {
        Transaction data;
        Node next;
        Node prev;

        public Node(Transaction data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static class TransactionNotFoundException extends Exception {
        public TransactionNotFoundException(String message) {
            super(message);
        }
    }
}

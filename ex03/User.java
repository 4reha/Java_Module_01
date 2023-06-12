public class User {
    private final int ID;
    private String name;
    private long balance;
    private final TransactionsList transactions;

    public User(String name, long balance, int id) {
        this.ID = UserIdsGenerator.getInstance().generateId();
        this.setName(name);
        this.setBalance(balance);
        transactions = new TransactionsLinkedList();
    }

    public User(String name) {
        this.ID = UserIdsGenerator.getInstance().generateId();
        this.setName(name);
        this.setBalance(0);
        transactions = new TransactionsLinkedList();
    }

    public int getId() {
        return ID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        if (balance < 0)
            balance = 0;
        this.balance = balance;
    }

    public Transaction[] getTransactions() {
        return transactions.toArray();
    }
    public void addTransaction(Transaction transaction) {
        this.transactions.addTransaction(transaction);
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", balance=" + getBalance() +
                '}';
    }
}

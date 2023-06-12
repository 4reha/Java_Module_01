public class User {
    private final int ID;
    private String name;
    private long balance;

    public User(int id, String name, long balance) {
        this.ID = id;
        this.setName(name);
        this.setBalance(balance);
    }

    public User(int id, String name) {
        this.ID = id;
        this.setName(name);
        this.setBalance(0);
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", balance=" + getBalance() +
                '}';
    }
}

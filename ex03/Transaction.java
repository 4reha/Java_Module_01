import java.util.UUID;

public class Transaction {
    private final UUID ID;
    private User recipient;
    private User sender;
    private final long AMOUNT;

    enum category {
        CREDITS,
        DEBITS,
    }

    private final category CATEGORY;
    private Boolean status;

    public Transaction(User recipient, User sender, long amount, category category) {
        this.ID = UUID.randomUUID();
        this.setRecipient(recipient);
        this.setSender(sender);
        this.AMOUNT = amount;
        this.CATEGORY = category;
        this.status = (this.getSender().getBalance() >= this.getAMOUNT() && this.getAMOUNT() > 0);
    }

    public void execute() {
        if (!this.getStatus()) {
            System.err.println("Transaction " + this.getID() + " failed");
            return;
        }
        this.getSender().addTransaction(this);
        this.getRecipient().addTransaction(this);
        this.getRecipient().setBalance(this.getRecipient().getBalance() + this.getAMOUNT());
        this.getSender().setBalance(this.getSender().getBalance() - this.getAMOUNT());
    }

    public UUID getID() {
        return ID;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public long getAMOUNT() {
        return AMOUNT;
    }

    public String getCATEGORY() {
        return CATEGORY.toString();
    }

    public Boolean getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + this.getID() +
                ", recipient=" + this.getRecipient() +
                ", sender=" + this.getSender() +
                ", amount=" + this.getAMOUNT() +
                ", category=" + this.getCATEGORY() +
                ", OK=" + getStatus() +
                '}';
    }
}

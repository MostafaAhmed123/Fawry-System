import java.time.LocalDateTime;

public class Transaction {
    static int ID = 0;
    private User user;
    private LocalDateTime date;
    private double amount;

    public Transaction(int ID, User user, double amount) {
        Transaction.ID = ID;
        this.user = user;
        this.date = LocalDateTime.now();
        this.amount = amount;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        Transaction.ID = ID;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate() {
        this.date = LocalDateTime.now();
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}

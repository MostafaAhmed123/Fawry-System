import java.time.LocalDateTime;

public class Transaction {
    private int ID;
    private User user;
    private LocalDateTime date;
    private float amount;

    public Transaction(int ID, User user, LocalDateTime date, float amount) {
        this.ID = ID;
        this.user = user;
        this.date = date;
        this.amount = amount;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
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

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}

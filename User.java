public class User {
    private String userName, password, email;
    private Wallet wallet;
    private int cnt = 0;
    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.wallet = new Wallet();
    }
    public int getCnt() {
        return cnt;
    }
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Wallet getWallet() {
        return wallet;
    }
    public void setWallet(float amount) {
        this.wallet.addToWallet(amount);
    }
}

public class User {
    private String userName, password, email;
    private WalletMethod wallet = new WalletMethod();
    private int cnt = 0;
    private boolean loggedIn;
    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        loggedIn = false;
    }
    public int getCnt() {
        return cnt;
    }
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
    public boolean hasOverallDiscount(){
        return cnt==0;
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
    @Override
    public String toString(){
        return userName;
    }

    public WalletMethod getWallet() {
        return wallet;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}

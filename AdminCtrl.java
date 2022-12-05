import java.util.ArrayList;

public class AdminCtrl {
    private String username, email, password;
    private boolean logIn;
    private Logger log = new Logger();
    public boolean isLogIn() {
        return logIn;
    }
    private int idxRefund = 0;
    public boolean signIn(String email, String password){
        if(getEmail().equalsIgnoreCase(email)&&getPassword().equals(password)){
            setLogIn(true);
            return true;
        }
        return false;
    }
    public void setLogIn(boolean logIn) {
        this.logIn = logIn;
    }
    public void addDiscount(ArrayList<Object> a){
        if(!isLogIn()) {
            System.out.println("access denied you are not logged in as admin user");
            return;
        }
        double percentage = Double.parseDouble(a.get(1).toString()) / 100;
        if("overall discount".contains(a.get(0).toString().toLowerCase()))
            overallDiscount.discount = percentage;
        else if("specific discount".contains(a.get(0).toString().toLowerCase())){
            for(int i = 0;i<log.getServices().size();i++){
                if(a.get(2).toString().toLowerCase().contains(log.getServices().get(i).getName().toLowerCase())){
                    log.getServices().get(i).setHasDiscount(true);
                    log.getServices().get(i).setDiscount(percentage);
                }
            }
        }
    }
    public ArrayList<Integer> getRefund(){
        return log.getRefundRequests();
    }
    public void makeDecision(int id){
        if(!isLogIn()) {
            System.out.println("access denied you are not logged in as admin user");
            return;
        }
        ArrayList<User> u =log.getUsers();
        for(int i =0;i<u.size();i++){
            if(u.get(i) == log.getPtransactions().get(id).getUser()){
                u.get(i).getWallet().addToWallet(log.getPtransactions().get(id).getAmount());
                log.addRefundTransaction(new Transaction(idxRefund,u.get(i),-1*log.getPtransactions().get(id).getAmount()));
                idxRefund++;
                log.getRefundRequests().removeIf(n -> (n == id));
            }
        }
    }
    public boolean addNewServiceProvider(String serviceName, ServiceProvider p){
        if(!isLogIn()) {
            System.out.println("access denied you are not logged in as admin user");
            return false;
        }
        for(int i =0;i<log.getServices().size();i++){
            if(log.getServices().get(i).getName().equalsIgnoreCase(serviceName)){
                return log.getServices().get(i).addProvider(p);
            }
        }
        return false;
    }
    public ArrayList<ArrayList<Transaction>> getAllTransactions(){
        ArrayList<ArrayList<Transaction>> tmp = new ArrayList<>();
        tmp.add(log.getPtransactions());
        tmp.add(log.getAWtransactions());
        tmp.add(log.getRefundTransactions());
        return tmp;
    }
    public void logOut(){
        setLogIn(false);
    }
    public AdminCtrl(){
        username = "mostafa";
        email = "mostafa@yahoo.com";
        password = "20206073";
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

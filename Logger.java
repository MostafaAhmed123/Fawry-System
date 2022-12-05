import java.util.ArrayList;
public class Logger {
    private static ArrayList<User> users;
    private static ArrayList<Transaction> Ptransactions;
    private static ArrayList<Transaction> AWtransactions;
    private static ArrayList<Transaction> refundTransactions;
    private static ArrayList<Integer> refundRequests;
    private static ArrayList<Service> services;
    public Logger() {
        users = new ArrayList<>();
        Ptransactions = new ArrayList<>();
        AWtransactions = new ArrayList<>();
        refundTransactions = new ArrayList<>();
        refundRequests = new ArrayList<>();
        services = new ArrayList<>();
    }
    public Logger(ArrayList<User> users, ArrayList<Service> s) {
        this.users = users;
        services = s;
    }
    public ArrayList<Service> getServices() {
        return services;
    }
    public ArrayList<User> getUsers() {
        return users;
    }
    public ArrayList<Transaction> getPtransactions() {
        return Ptransactions;
    }
    public ArrayList<Transaction> getAWtransactions() {
        return AWtransactions;
    }
    public ArrayList<Transaction> getRefundTransactions() {
        return refundTransactions;
    }
    public void addUser(User user){
        users.add(user);
    }
    public void addPtransaction(Transaction t){
        Ptransactions.add(t);
    }
    public void addIndex(int id){
        refundRequests.removeIf(n -> (n == id));
        refundRequests.add(id);
    }
    public ArrayList<Integer> getRefundRequests(){
        return refundRequests;
    }
    public void addAWtransaction(Transaction t){
        AWtransactions.add(t);
    }
    public void addRefundTransaction(Transaction t){
        refundTransactions.add(t);
    }
    public boolean search(String name, String email){
        for(int i = 0;i<users.size();i++)
            if(users.get(i).getUserName().equals(name) || users.get(i).getEmail().equals(email))
                return true;
        return false;
    }
}

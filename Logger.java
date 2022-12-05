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
        ArrayList<ServiceProvider> p = new ArrayList<>();
        p.add(new ServiceProvider("Vodafone"));
        p.add(new ServiceProvider("Etisalat"));
        p.add(new ServiceProvider("We"));
        p.add(new ServiceProvider("Orange"));
        services.add(new Service(p));
        services.get(0).setName("MobileRechargeServices");
        services.get(0).setCost(20);
        services.add(new Service(p));
        services.get(1).setName("InternetPaymentServices");
        services.get(1).setCost(40);
        ArrayList<ServiceProvider> tmp = new ArrayList<>();
        tmp.add(new ServiceProvider("Monthly receipt"));
        tmp.add(new ServiceProvider("Quarter receipt"));
        services.add(new Service(tmp));
        services.get(2).setName("LandlineServices");
        services.get(2).setCost(60);
        tmp = new ArrayList<>();
        tmp.add(new ServiceProvider("Cancer Hospital"));
        tmp.add(new ServiceProvider("Schools"));
        tmp.add(new ServiceProvider("NGOs"));
        services.add(new Service(tmp));
        services.get(3).setName("Donations");
        services.get(3).setCost(10);
    }
    public Logger(ArrayList<User> users, ArrayList<Service> s) {
        Logger.users = users;
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

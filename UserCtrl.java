import java.util.ArrayList;
public class UserCtrl {
    private Logger log;
    private int idxP = 0, idxAW = 0;
    User curUser;
    public UserCtrl(){
        log = new Logger();
    }
    public boolean signUp(String userName, String email, String password){
        if(log.search(userName, email))
            return false;
        else{
            log.addUser(new User(userName, password, email));
        }
        return true;
    }
    public boolean signIn(String email, String password){
        ArrayList<User> u = log.getUsers();
        for(int i = 0;i<u.size(); i++)
            if(u.get(i).getEmail().equals(email) && u.get(i).getPassword().equals(password)) {
                curUser = u.get(i);
                u.get(i).setLoggedIn(true);
                return true;
            }
        return false;
    }
    public boolean makeRefundRequest(int id){
        if(log.getPtransactions().get(id).getUser().equals(curUser)){
            log.addIndex(id);
            return true;
        }
        return false;
    }
    public void logOut(String userName){
        for (int i =0 ;i<log.getUsers().size();i++){
            if(log.getUsers().get(i).getUserName().equalsIgnoreCase(userName)){
                log.getUsers().get(i).setLoggedIn(false);
            }
        }
    }
    public boolean payForService(String serviceName, Payment method, String username){
        for(int i =0;i<log.getServices().size();i++){
            if(log.getServices().get(i).getName().equals(serviceName)){
                AbstractService s = log.getServices().get(i);
                for(int j =0;j<log.getUsers().size();j++){
                    if(log.getUsers().get(j).getUserName().equals(username)){
                        if(log.getUsers().get(j).hasOverallDiscount())
                            s = new overallDiscount(s);
                        if(log.getServices().get(i).hasDiscount()){
                            specificDiscount temp = new specificDiscount(s);
                            temp.setDiscount(log.getServices().get(i).getDiscount());
                            s = new specificDiscount(temp);
                        }
                        double amount = s.getCost();
                        if(method.getClass().getName().equalsIgnoreCase("wallet")){
                            if(log.getUsers().get(j).getWallet().pay(amount)) {
                                log.getUsers().get(j).setCnt(log.getUsers().get(j).getCnt() + 1);
                                log.addPtransaction(new Transaction(idxP, log.getUsers().get(j), amount));
                                idxP++;
                                return true;
                            }
                        }
                        else if(method.getClass().getName().equalsIgnoreCase("cash on delivery") && log.getServices().get(i).acceptCash()){
                            method.pay(amount);
                            log.addPtransaction(new Transaction(idxP,log.getUsers().get(j),amount));
                            idxP++;
                            log.getUsers().get(j).setCnt(log.getUsers().get(j).getCnt()+1);
                            return true;
                        }
                        else{
                            if(method.pay(amount)) {
                                log.addPtransaction(new Transaction(idxP, log.getUsers().get(j), amount));
                                log.getUsers().get(j).setCnt(log.getUsers().get(j).getCnt() + 1);
                                idxP++;
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public void addToWallet(String username, double amount, Payment method){
        for(int i =0;i<log.getUsers().size();i++){
            ArrayList<User> u = log.getUsers();
            User tmp = u.get(i);
            if(tmp.getUserName().equals(username) && method.getName().equalsIgnoreCase("credit card")) {
                method.pay(amount);
                log.getUsers().get(i).getWallet().addToWallet(amount);
                log.addAWtransaction(new Transaction(idxAW,log.getUsers().get(i), amount));
                idxAW++;
            }
        }
    }
    public ArrayList<Service> searchForService(String serviceName){
        ArrayList<Service> s = new ArrayList<>();
        for(int i = 0;i<log.getServices().size();i++){
            String name = log.getServices().get(i).getName();
            if(serviceName.toLowerCase().contains(name)){
                s.add(log.getServices().get(i));
            }
        }
        return s;
    }
    public double hasDiscount(String serviceName){
        for (int i =0;i<log.getServices().size();i++){
            if(log.getServices().get(i).getName().equalsIgnoreCase(serviceName) && log.getServices().get(i).hasDiscount())
                return log.getServices().get(i).getDiscount();
        }
        return -1;
    }
}
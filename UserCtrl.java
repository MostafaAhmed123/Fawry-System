import java.util.ArrayList;
public class UserCtrl {
    private Logger log;
    User curUser;
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
//    public void addToWallet(float amount){
//        if(amount>0)
//            curUser.setWallet(amount);
//    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class Screen {
    static Scanner scan = new Scanner(System.in);
    private UserCtrl Uctrl;
    private AdminCtrl Actrl;
    public Screen(){
        Uctrl = new UserCtrl();
        Actrl = new AdminCtrl();
    }
    public void setInitialData(){
        System.out.println("we put this data to test the program easily, and you can use it also");
        System.out.println("Users: ");
        System.out.println("mostafa" +" mostafa@123" +" 123");
        System.out.println("amr"+" amr@123" + " 456");
        System.out.println("mohamed"+" mohamed@123" + " 789");
        Uctrl.signUp("mostafa","mostafa@123","123");
        Uctrl.signUp("amr","amr@123","456");
        Uctrl.signUp("mohamed","mohamed@123","789");
    }
    public void listAllTransactions(){
        ArrayList<ArrayList<Transaction>> tmp = Actrl.getAllTransactions();
        System.out.println("Payment transactions are: ");
        for(int i =0;i<tmp.get(0).size();i++)
            System.out.println(tmp.get(0).get(i));
        System.out.println("Add to wallet transactions are:");
        for(int i =0;i<tmp.get(1).size();i++)
            System.out.println(tmp.get(1).get(i));
        System.out.println("Refund transactions are:");
        for(int i =0;i<tmp.get(2).size();i++)
            System.out.println(tmp.get(2).get(i));
    }
    public void refundRequests(){
        ArrayList<Integer> tmp = Actrl.getRefund();
        ArrayList<ArrayList<Transaction>> tmp2 = Actrl.getAllTransactions();
        String choice;
        for(int i =0 ;i<tmp.size();i++){
            System.out.println("press 1 to approve, 2 to refuse, and anything else except e/E to ignore for now, if you want to exit this choice press e/E");
            System.out.println(tmp2.get(0).get(tmp.get(i)));
            choice = scan.next();
            if(choice.equals("1")) {
                Actrl.makeDecision(tmp.get(i));
            }
            else if(choice.equals("2")) {
                tmp.remove(tmp.get(i));
            }
            else if(choice.equalsIgnoreCase("e"))
                break;
        }
    }
    public void displayUserMenu(){
        System.out.println("1- Pay for Service");
        System.out.println("2- Add to wallet");
        System.out.println("3- Search for specific service");
        System.out.println("4- Make refund request");
        System.out.println("5- Check if service has discounts");
        System.out.println("6- your wallet balance");
        System.out.println("7- Logout");
    }
    public void displayAdminMenu(){
        System.out.println("1- Add discount");
        System.out.println("2- List all transactions");
        System.out.println("3- Make decision in refund requests");
        System.out.println("4- Logout");
    }
    public static void main(String[] args){
        Screen s = new Screen();
        s.setInitialData();
        while(true){
            String choice;
            System.out.println("1- Sign in");
            System.out.println("2- Sign up as a new user");
            System.out.println("exit/Exit to close the program");
            System.out.println("Enter your choice");
            choice = scan.next();
            if(choice.equals("1")){
                String email, password;
                System.out.println("Enter your email: ");
                email = scan.next();
                System.out.println("Enter your password");
                password = scan.next();
                if(s.Uctrl.signIn(email, password)) {
                    System.out.println("You logged in successfully as regular user");
                    while (true) {
                        String tmpUser;
                        s.displayUserMenu();
                        System.out.println("Enter your choice");
                        tmpUser = scan.next();
                        if(tmpUser.equals("1")){
                            String serviceName;
                            System.out.println("Enter service name");
                            serviceName = scan.next();
                            System.out.println("Enter Payment method");
                            String method;
                            method = scan.next();
                            Payment p;
                            if(method.equalsIgnoreCase("cash on delivery")){
                                System.out.println("Enter your address");
                                String address;
                                address = scan.next();
                                p = new cashOnDelivery(address);
                                s.Uctrl.payForService(serviceName, p, s.Uctrl.curUser.getUserName());
                            }
                            else if(method.equalsIgnoreCase("wallet")){
                                s.Uctrl.payForService(serviceName, s.Uctrl.curUser.getWallet(), s.Uctrl.curUser.getUserName());
                            }
                            else{
                                System.out.println("Enter card number");
                                String cardNum;
                                cardNum = scan.next();
                                System.out.println("Enter password");
                                String pass = scan.next();
                                System.out.println("Enter the current balance in your card");
                                double balance = scan.nextDouble();
                                p = new credit(balance, cardNum,pass);
                                s.Uctrl.payForService(serviceName, p, s.Uctrl.curUser.getUserName());
                            }
                        }
                        else if(tmpUser.equals("2")){
                            System.out.println("Enter card number");
                            String cardNum;
                            cardNum = scan.next();
                            System.out.println("Enter password");
                            String pass = scan.next();
                            System.out.println("Enter the amount to be added");
                            double balance = scan.nextDouble();
                            Payment p = new credit(balance,cardNum, pass);
                            s.Uctrl.addToWallet(s.Uctrl.curUser.getUserName(),balance, p);
                            System.out.println("The amount added successfully");
                        }
                        else if(tmpUser.equals("3")){
                            System.out.println("Enter the service name");
                            String serviceName = scan.next();
                            ArrayList<Service> tmp = s.Uctrl.searchForService(serviceName);
                            for(int i = 0;i<tmp.size();i++){
                                tmp.get(i).printServiceProviders();
                            }
                        }
                        else if(tmpUser.equals("4")){
                            int id;
                            System.out.println("Enter transaction ID");
                            id = scan.nextInt();
                            try {
                                if (s.Uctrl.makeRefundRequest(id)) {
                                    System.out.println("The request has been forwarded to the admin and he will accept or refuse it");
                                } else {
                                    System.out.println("we can't find transaction with id " + id + " made by you");
                                }
                            }
                            catch (Exception e){
                                System.out.println("you entered wrong id");
                            }
                        }
                        else if(tmpUser.equals("5")){
                            System.out.println("Enter service name");
                            String servicename = scan.next();
                            if(s.Uctrl.hasDiscount(servicename)!=-1){
                                System.out.println("The service has discount: " + s.Uctrl.hasDiscount(servicename));
                            }
                            System.out.println("The service doesn't have any discounts");
                        }
                        else if(tmpUser.equals("7")){
                            s.Uctrl.logOut(s.Uctrl.curUser.getUserName());
                            System.out.println("you are now logged out");
                            break;
                        }
                        else if(tmpUser.equals("6")){
                            System.out.println(s.Uctrl.curUser.getWallet().getBalance());
                        }
                    }
                }
                else if(s.Actrl.signIn(email,password)){
                    System.out.println("you log in successfully as admin user");
                    while (true){
                        String tmpAdmin;
                        s.displayAdminMenu();
                        System.out.println("Enter your choice");
                        tmpAdmin = scan.next();
                        if(tmpAdmin.equals("1")){
                            System.out.println("Enter the type of your discount");
                            String type = scan.next();
                            ArrayList<Object> tmp = new ArrayList<>();
                            tmp.add(type);
                            System.out.println("Enter the discount percentage");
                            double percentage = scan.nextDouble();
                            tmp.add(percentage);
                            if("specific discount".contains(type.toLowerCase())){
                                System.out.println("Enter service name to apply discount");
                                String serviceName = scan.next();
                                tmp.add(serviceName);
                            }
                            s.Actrl.addDiscount(tmp);
                        }
                        else if(tmpAdmin.equals("2")){
                            s.listAllTransactions();
                        }
                        else if(tmpAdmin.equals("3")){
                            s.refundRequests();
                        }
                        else if(tmpAdmin.equals("4")){
                            s.Actrl.logOut();
                            System.out.println("You are now logged out");
                            break;
                        }
                    }
                }
                else{
                    System.out.println("Wrong Email or password try again");
                    continue;
                }
            }
            if(choice.equals("2")){
                System.out.println("Enter valid email");
                String e = scan.next();
                System.out.println("Enter username");
                String u = scan.next();
                System.out.println("Enter your password");
                String p = scan.next();
                if(s.Uctrl.signUp(u,e,p)){
                    System.out.println("The account created successfully");
                }
                else
                    System.out.println("the email or username taken before");
            }
            else if(choice.equalsIgnoreCase("exit"))
                break;
        }
    }
}

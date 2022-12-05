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
        System.out.println("6- Logout");
    }
    public void displayAdminMenu(){
        System.out.println("1- Add discount");
        System.out.println("2- List all transactions");
        System.out.println("3- Add existed service provider to a existing service");
        System.out.println("4- Make decision in refund requests");
        System.out.println("5- Logout");
    }
    public static void main(String[] args){
        Screen s = new Screen();
        while(true){
            String choice;
            System.out.println("1- Sign in");
            System.out.println("2- Sign up as a new user");
            System.out.println("Anything else to close the program");
            System.out.println("Enter your choice");
            choice = scan.next();
            if(choice.equals("1")){
                String email, password;
                System.out.println("Enter your email: ");
                email = scan.nextLine();
                System.out.println("Enter your password");
                password = scan.nextLine();
                if(s.Uctrl.signIn(email, password)) {
                    System.out.println("You logged in successfully as regular user");
                    while (true) {
                        String tmpUser;
                        s.displayUserMenu();
                        System.out.println("Enter your choice");
                        tmpUser = scan.next();
                        if(tmpUser.equals("1")){
                            System.out.println("Enter service name");
                            String serviceName;
                            serviceName = scan.next();
                            System.out.println("Enter Payment method");
                            String method;
                            method = scan.nextLine();
                            Payment p;
                            if(method.equalsIgnoreCase("cash on delivery")){
                                System.out.println("Enter your address");
                                String address;
                                address = scan.nextLine();
                                p = new cashOnDelivery(address);
                                s.Uctrl.payForService(serviceName, p, s.Uctrl.curUser.getUserName());
                            }
                            else if(method.equalsIgnoreCase("wallet")){
                                s.Uctrl.payForService(serviceName, s.Uctrl.curUser.getWallet(), s.Uctrl.curUser.getUserName());
                            }
                            else{
                                System.out.println("Enter card number");
                                String cardNum;
                                cardNum = scan.nextLine();
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
                            cardNum = scan.nextLine();
                            System.out.println("Enter password");
                            String pass = scan.next();
                            System.out.println("Enter the amount to be added");
                            double balance = scan.nextDouble();
                            Payment p = new credit(balance,cardNum, pass);
                            s.Uctrl.curUser.getWallet().addToWallet(balance);
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
                        }
                    }
                }
            }
        }
    }
}

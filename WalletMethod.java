public class WalletMethod extends Payment{
	public void addToWallet(double amount){
		setBalance(getBalance()+amount);
	}
	@Override
	public  boolean pay(double amount){
		if(amount>getBalance())
			return false;
		setBalance(getBalance()-amount);
		return true;
	}
	public WalletMethod(){
		name = "wallet";
	}
}

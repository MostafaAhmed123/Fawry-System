
public abstract class Payment {
	private double balance;
	protected String name = "unnamed method";
	public String getName(){
		return name;
	}
	public abstract boolean pay(double amount) ;
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

}

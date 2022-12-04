
public abstract class Payment {
	private double balance;
	public abstract boolean pay(double amount) ;
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

}

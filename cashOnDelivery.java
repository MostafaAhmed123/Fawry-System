public class cashOnDelivery extends Payment{
	private String address;
	@Override
	public  boolean pay(double amount) {
		setBalance(getBalance() - amount);
		return true;
	}
	public void setAddress(String s){
		address = s;
	}
	public String getAddress(){
		return address;
	}
}

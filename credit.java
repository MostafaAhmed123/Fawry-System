public class credit extends Payment {
	private String cardNum, password;
	public credit(double b, String cardNum, String pass){
		this.cardNum = cardNum;
		this.password = pass;
		name ="credit card";
		setBalance(b);
	}
	@Override
	public  boolean pay(double amount) {
		if(amount>getBalance())
			return false;
		setBalance(getBalance()-amount);
		return true;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

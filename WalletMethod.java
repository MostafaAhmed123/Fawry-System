package fawry;

public class Wallet extends Payment{
	public Wallet(Service s) {
		description="using wallet";
		service = s;
	}
	@Override
	public  double calculate() {
		return s.getCost();
	}

}

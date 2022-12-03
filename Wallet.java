package fawry;

public class Wallet extends Payment{
	public Wallet() {
		description="using wallet";
	}
	@Override
	public  double calculate(float cost) {
		return getCost();
	}

}

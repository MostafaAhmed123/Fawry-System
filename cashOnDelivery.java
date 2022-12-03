package fawry;

public class cashOnDelivery extends Payment{
	public cashOnDelivery(Service s) {
		description = "using cashOnDelivery";
		service = s;
	}
	@Override
	public  double calculate() {
		return s.getCost();
	}
}

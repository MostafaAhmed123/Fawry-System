package fawry;

public class credit extends Payment {
	
	public credit(Service s) {
		description="using credit";
		service = s;
	}
	@Override
	public  double calculate() {
		return s.getCost();
	}
}

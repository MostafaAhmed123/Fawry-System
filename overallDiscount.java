package fawry;

public class overallDiscount extends DiscountDecorator {

	public overallDiscount(Payment payment) {
		this.pay=payment;
	}
	public String getDescription() {
		return pay.getDescription() +"  ,overallDiscount";
	}
	
	@Override
	public  double calculate(float cost) {
		return    pay.getCost() * (1-discount);
		
	}

}

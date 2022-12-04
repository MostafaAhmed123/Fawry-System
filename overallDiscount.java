public class overallDiscount extends DiscountDecorator {

	public overallDiscount(Payment payment) {
		this.pay=payment;
	}
	public String getDescription() {
		return pay.getDescription() +"  ,overallDiscount";
	}
	
	@Override
	public  double calculate() {
		return    pay.calculate() * (1-discount);
		
	}

}

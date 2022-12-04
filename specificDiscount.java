public class specificDiscount extends DiscountDecorator{
	public specificDiscount(Payment payment) {
		this.pay=payment;
	}
	public String getDescription() {
		return pay.getDescription() + "  ,specificDiscount";
	}
	@Override
	public  double calculate() {
		return   pay.calculate()*(1-discount) ;
		
	}

}

package fawry;

public class specificDiscount extends DiscountDecorator{
	Payment payment;
	public specificDiscount(Payment payment) {
		this.payment=payment;
	}
	public String getDescription() {
		return payment.getDescription() +"  ,specificDiscount";
	}
	@Override
	public  double calculate(float cost) {
		return   payment.getCost()* ;
		
	}

}

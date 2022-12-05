public class overallDiscount extends DiscountDecorator {

	public overallDiscount(AbstractService service) {
		this.service=service;
	}
	public String getName() {
		return service.getName() +"  ,overallDiscount";
	}
	public static double discount;
	public double getDiscount(){
		return discount;
	}
	public void setDiscount(double discount) {
		overallDiscount.discount = discount;
	}
	@Override
	public  double getCost() {
		return service.getCost() * (1-discount);
		
	}

}

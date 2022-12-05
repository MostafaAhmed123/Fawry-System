public class specificDiscount extends DiscountDecorator{
	private double discount;
	public specificDiscount(AbstractService service) {
		discount = 0;
		this.service=service;
	}
	public String getName() {
		return service.getName() + "  ,specificDiscount";
	}
	public double getDiscount(){
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	@Override
	public  double getCost() {
		return   service.getCost() * (1 - discount);
		
	}

}

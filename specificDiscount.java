public class specificDiscount extends DiscountDecorator{
	public specificDiscount(AbstractService service) {
		this.service=service;
	}
	public String getName() {
		return service.getName() + "  ,specificDiscount";
	}
	@Override
	public  double getCost() {
		return   service.getCost() * (1 - discount);
		
	}

}

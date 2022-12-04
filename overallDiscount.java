public class overallDiscount extends DiscountDecorator {

	public overallDiscount(AbstractService service) {
		this.service=service;
	}
	public String getName() {
		return service.getName() +"  ,overallDiscount";
	}
	
	@Override
	public  double getCost() {
		return service.getCost() * (1-discount);
		
	}

}

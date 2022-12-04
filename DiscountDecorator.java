public abstract class DiscountDecorator extends AbstractService{
    protected AbstractService service;
    protected double discount;

    public double getDiscount(){
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public abstract double getCost();

}

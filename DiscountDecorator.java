public abstract class DiscountDecorator extends Payment{
    protected Payment pay;
    protected float discount;
    
    public float getDiscount(){
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public abstract String getDescription();
    @Override
	public abstract double calculate();
    
}

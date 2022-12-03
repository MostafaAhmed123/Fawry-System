package fawry;

public abstract class Payment {
	String description= "unkown method";
	
	public String getDescription() {
		return description;
	}
	public abstract double getCost(float cost) ;

}

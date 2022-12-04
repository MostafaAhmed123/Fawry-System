package fawry;

public abstract class Payment {
	protected Service service;
	String description= "unkown method";
	public String getDescription() {
		return description;
	}
	public abstract double calculate() ;

}

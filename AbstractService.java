public abstract class AbstractService {
    protected double cost;
    protected String name = "Unnamed service";
    public String getName() {
        return name;
    }
    abstract double getCost();
}

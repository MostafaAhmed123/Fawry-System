import java.util.ArrayList;
public class Service extends AbstractService{
    private boolean cash, hasDiscount;
    private ArrayList<ServiceProvider> serviceProviders;
    public Service(){
        serviceProviders = new ArrayList<>();
    }
    public Service(ArrayList<ServiceProvider> p){
        serviceProviders = p;
    }
    @Override
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public ArrayList<ServiceProvider> getProviders(){
        return serviceProviders;
    }
    public boolean addProvider(ServiceProvider p){
        if(serviceProviders.contains(p))
            return false;
        serviceProviders.add(p);
        return true;
    }
    public boolean acceptCash() {
        return cash;
    }
    public void setCash(boolean cash) {
        this.cash = cash;
    }
    public boolean removeProvider(ServiceProvider p){
        if(serviceProviders.contains(p)){
            serviceProviders.remove(p);
            return true;
        }
        return false;
    }

    public boolean hasDiscount() {
        return hasDiscount;
    }

    public void setHasDiscount(boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
    }
    public void setName(String name) {
        this.name = name;
    }
}

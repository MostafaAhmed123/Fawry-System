import java.util.ArrayList;
public class Service{
    private double cost;
    private String name = "Un named service";
    private ArrayList<ServiceProvider> serviceProviders;
    public Service(){
        serviceProviders = new ArrayList<>();
    }
    public Service(ArrayList<ServiceProvider> p){
        serviceProviders = p;
    }
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
    public boolean removeProvider(ServiceProvider p){
        if(serviceProviders.contains(p)){
            serviceProviders.remove(p);
            return true;
        }
        return false;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

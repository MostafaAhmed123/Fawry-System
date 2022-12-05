public class ServiceProvider {
    private UserForm form;
    private String name = "unnamed provider";
    public ServiceProvider(String n){
        name = n;
    }
    @Override
    public String toString(){
        return name;
    }
    public String getName(){
        return name;
    }
}
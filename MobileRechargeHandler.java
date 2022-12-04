public class MobileRechargeHandler implements Handler{
    @Override
    public void handleRequests(Form f){
        IField field = f.getFields();
        System.out.println(field.getField());
    }
}

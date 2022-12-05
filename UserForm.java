public class UserForm {
    private IField fields;
    public IField getFields() {
        return fields;
    }
    public void setFields(IField fields) {
        this.fields = fields;
    }
    public UserForm(int numOftextFields, int numOfDropDownFields){
        fields = new Form();

    }
}
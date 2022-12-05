public class textField implements IField{
    private String textField;
    private String value;
    @Override
    public Object getField(){
        return textField;
    }
    public String getTextField() {
        return textField;
    }
    public void setTextField(String textField) {
        this.textField = textField;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}

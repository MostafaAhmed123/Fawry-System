import java.util.ArrayList;

public class UserForm implements IField{
    private ArrayList<IField> fields = new ArrayList<>();
    public void addToForm(IField field) {
        this.fields.add(field);
    }
    @Override
    public Object getField() {
        return fields;
    }
}
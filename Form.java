import java.util.ArrayList;

public class Form implements IField{
    private ArrayList<IField> fields = new ArrayList<>();
    public void addToForm(IField field) {
        this.fields.add(field);
    }
    public void removeFromForm(IField field){ this.fields.remove(field);}
    @Override
    public Object getField() {
        return fields;
    }
}
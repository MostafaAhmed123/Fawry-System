import java.util.ArrayList;
public class DropDownField implements IField{
    private ArrayList<String> choices = new ArrayList<>();
    public void setChoices(ArrayList<String> choices) {
        this.choices = choices;
    }
    @Override
    public Object getField() {
        return choices;
    }
}

import java.util.ArrayList;

public class Boat {

    String name;
    String type;
    Double baseprice;

    Boat(String name, String type, Double baseprice){
        this.name = name;
        this.type = type;
        this.baseprice = baseprice;
    }

    ArrayList<Option>options = new ArrayList<>();
    ArrayList<Option>extraOptions = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBaseprice(Double baseprice) {
        this.baseprice = baseprice;
    }

    public void addOption(Option option) {
        options.add(option);
    }

    public void addExtraOption(Option extraOption) {
        extraOptions.add(extraOption);
    }

    public void removeOption(Option option) {
        options.remove(option);
    }

    public void removeExtraOption(Option extraOption) {
        extraOptions.remove(extraOption);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Double getBaseprice() {
        return baseprice;
    }

    public ArrayList<Option> getOptions() {
        return options;
    }

    public ArrayList<Option> getExtraOptions() {
        return extraOptions;
    }


}

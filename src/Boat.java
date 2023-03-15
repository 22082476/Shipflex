import java.util.ArrayList;

public class Boat {

   private String name;
   private String type;
   private double basePrice;
   private ArrayList<Option> options;
   private ArrayList<Option> extraOptions;

    Boat(String name, String type, double baseprice){
        this.name = name;
        this.type = type;
        this.basePrice = baseprice;
        options = new ArrayList<>();
        extraOptions = new ArrayList<>();
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public void addOption(Option option) {
       this.options.add(option);
    }

    public void addExtraOption(Option extraOption) {
        this.extraOptions.add(extraOption);
    }

    public void removeOption(Option option) {
       this.options.remove(option);
    }

    public void removeExtraOption(Option extraOption) {
        this.extraOptions.remove(extraOption);
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public double getBasePrice() {
        return this.basePrice;
    }

    public ArrayList<Option> getOptions() {
        return this.options;
    }

    public ArrayList<Option> getExtraOptions() {
        return this.extraOptions;
    }


}

import java.util.ArrayList;

public class Boat {

   private String name;
   private String type;
   private double basePrice;
   private ArrayList<Option> essentialoptions;
   private ArrayList<Option> extraOptions;

    Boat(String name, String type, double basePrice){
        this.name = name;
        this.type = type;
        this.basePrice = basePrice;
        this.essentialoptions = new ArrayList<>();
        this.extraOptions = new ArrayList<>();
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

    public void addEssentialOption(Option option) {
       this.essentialoptions.add(option);
    }

    public void addExtraOption(Option extraOption) {
        this.extraOptions.add(extraOption);
    }

    public void removeOption(Option option) {
       this.essentialoptions.remove(option);
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
        return this.essentialoptions;
    }

    public ArrayList<Option> getExtraOptions() {
        return this.extraOptions;
    }


}

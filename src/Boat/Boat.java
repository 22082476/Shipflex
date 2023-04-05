package Boat;

import java.util.ArrayList;

public class Boat {

   private String name;
   private String type;
   private double basePrice;
   private ArrayList<Option> options;

    Boat(String name, String type, double basePrice){
        this.name = name;
        this.type = type;
        this.basePrice = basePrice;
        this.options = new ArrayList<>();
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


    public void addOption(Option Option) {
        this.options.add(Option);
    }

    public void removeOption(Option option) {
       this.options.remove(option);
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


}

package Boat;

import DataInOut.Info;
import DataInOut.Printer;
import DataInOut.ScanInput;

import java.util.ArrayList;


public abstract class Boat {

   private String name;
   private String type;
   private double basePrice;
   private ArrayList<Option> options;

    public Boat(String name, String type, double basePrice){
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

    public void addOptionsFromNames(String[] names) {
        Option option;

        for (String name : names) {

            option = Info.getOptionFromName(name);

            if (option == null) {
                Printer.getInstance().printLine("Kon optie '" + name + "' niet toevoegen aan deze boot, want hij is niet gevonden.");
                continue;
            }

            addOption(option);
        }
    }
    public void printBoat(){
        Printer.getInstance().printLine("Bootnaam: " + getName());
        Printer.getInstance().printLine("Bootsoort: " + getType());
        Printer.getInstance().printLine("Basisprijs: " + String.format("%.2f", getBasePrice()));

    }

    public void changeBoat(){
        setName(ScanInput.inputQuestion("bootnaam"));
        setType(ScanInput.inputQuestion("boottype(" + getType() + ")"));
        setBasePrice(ScanInput.inputNumberD("basisprijs (" + getBasePrice()+ ")"));
    }


}

package Boat;

import DataInOut.Printer;

import java.util.List;

public class Option {

    private String name;
    private double price;
    private String type;
    private String description;
    private int environmentDiscount;

    private List<String> essentialForBoatType;

    private List<String> extraForBoatType;

    public Option(String name, double price, String type, int environmentDiscount, List<String> essentialForBoatType, List<String> extraForBoatType) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.environmentDiscount = environmentDiscount;
        this.essentialForBoatType = essentialForBoatType;
        this.extraForBoatType = extraForBoatType;
    }

    public Option(String name, double price, String type, int environmentDiscount, List<String> essentialForBoatType, List<String> extraForBoatType, String description){
        this(name, price, type, environmentDiscount, essentialForBoatType, extraForBoatType);
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnvironmentDiscount(int environmentDiscount) {
        this.environmentDiscount = environmentDiscount;
    }


    public List<String> getEssentialForBoatType() {
        return essentialForBoatType;
    }

    public List<String> getExtraForBoatType() {
        return extraForBoatType;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public String getType() {
        return this.type;
    }

    public String getDescription() {
        return this.description;
    }

    public int getEnvironmentDiscount() {
        return this.environmentDiscount;
    }

    // return de prijs met de discount erbij (als het discount heeft)
    public double calculateEnvironmentDiscount() {
        if(this.getEnvironmentDiscount() == 0)
            return this.getPrice();

        return this.getPrice() - (this.getPrice() / 100 * this.getEnvironmentDiscount());
    }

    public void printOptionInfoForBoat(String boatType) {

        Printer.getInstance().printFormatInfo(this.name);
        Printer.getInstance().printFormatInfo(this.type);
        Printer.getInstance().printFormatInfo(this.essentialForBoatType.contains(boatType.toLowerCase()) ? "Essentieel" : "Extra");
        Printer.getInstance().printLine(String.valueOf(String.format("%.2f", this.price)));

        if (this.environmentDiscount > 0) {
            Printer.getInstance().emptyLine();
            Printer.getInstance().printFormatInfo("");
            Printer.getInstance().printFormatInfo("Korting");
            Printer.getInstance().printFormatInfo(String.valueOf(this.environmentDiscount));
            Printer.getInstance().printFormatInfo(String.valueOf(this.calculateEnvironmentDiscount()));
            Printer.getInstance().emptyLine();
        }
    }

}
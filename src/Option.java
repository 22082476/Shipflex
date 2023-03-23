import java.util.ArrayList;

public class Option {

    private String name;
    private double price;
    private String type;
    private String description;
    private int environmentDiscount;

    private ArrayList<String> essentialForBoatType;

    private ArrayList<String> extraForBoatType;

    Option(String name, double price, String type, int environmentDiscount, ArrayList<String> essentialForBoatType, ArrayList<String> extraForBoatType) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.environmentDiscount = environmentDiscount;
        this.essentialForBoatType = essentialForBoatType;
        this.extraForBoatType = extraForBoatType;
    }

    Option(String name, double price, String type, int environmentDiscount, ArrayList<String> essentialForBoatType, ArrayList<String> extraForBoatType, String description){
        this(name, price, type, environmentDiscount, essentialForBoatType, extraForBoatType);
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEnvironmentDiscount(int environmentDiscount) {
        this.environmentDiscount = environmentDiscount;
    }

    public ArrayList<String> getEssentialForBoatType() {
        return essentialForBoatType;
    }

    public ArrayList<String> getExtraForBoatType() {
        return extraForBoatType;
    }

    public void addExtraForBoatType(String extraForBoatType) {
        this.extraForBoatType.add(extraForBoatType);
    }


    public void addEssentialForBoatType(String essentialForBoatType) {
        this.essentialForBoatType.add(essentialForBoatType);
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
}
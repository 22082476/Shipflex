import java.lang.reflect.Array;
import java.util.ArrayList;

public class Option {

    private String name;
    private double price;
    private String type;
    private String description;
    private boolean environmentDiscount;
    private ArrayList<String> essentialForBoatType;

    Option(String name, double price, String type, boolean environmentDiscount, ArrayList<String> essentialForBoatType) {
        this.essentialForBoatType = new ArrayList<>();
        this.name = name;
        this.price = price;
        this.type = type;
        this.environmentDiscount = environmentDiscount;
        this.essentialForBoatType = essentialForBoatType;
    }

    Option(String name, double price, String type, boolean environmentDiscount, ArrayList<String> essentialForBoatType, String description){
        this(name, price, type, environmentDiscount, essentialForBoatType);
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

    public void setEnvironmentDiscount(boolean environmentDiscount) {
        this.environmentDiscount = environmentDiscount;
    }

    public void addToEssentialForBoatType(String boat) {
        this.essentialForBoatType.add(boat);
    }

    public ArrayList<String> getEssentialForBoatTypes() {
        return this.essentialForBoatType;
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

    public boolean isEnvironmentDiscount() {
        return this.environmentDiscount;
    }
}
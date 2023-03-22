public class Option {

    private String name;
    private double price;
    private String type;
    private String description;
    private int environmentDiscount;

    Option(String name, double price, String type, int environmentDiscount) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.environmentDiscount = environmentDiscount;
    }

    Option(String name, double price, String type, int environmentDiscount, String description){
        this(name, price, type, environmentDiscount);
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
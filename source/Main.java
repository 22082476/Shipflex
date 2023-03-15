class Options{
    String name;
    double price;
    String type;
    String description;
    boolean environmentDiscount;

    Options(String name, double price, String type, String description, boolean environmentDiscount){
        this(name, price, type, environmentDiscount);
        this.description = description;
    }

    Options(String name, double price, String type, boolean enviromentDiscount) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.environmentDiscount = environmentDiscount;
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

    public void setEnvironmentDiscount(bwoolean environmentDiscount) {
        this.environmentDiscount = environmentDiscount;
    }
}

public class Main {
}

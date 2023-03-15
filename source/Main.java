class Options{
    String name;
    Double price;
    String type;
    String description;
    Boolean environmentDiscount;

    Options(String name, Double price, String type, String description, Boolean environmentDiscount){
        this.name = name;
        this.price = price;
        this.type = type;
        this.description = description;
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

    public void setEnvironmentDiscount(Boolean environmentDiscount) {
        this.environmentDiscount = environmentDiscount;
    }


}


public class Main {
}

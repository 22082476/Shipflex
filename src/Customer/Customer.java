package Customer;

import DataInOut.*;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    protected String name;
    protected String street;
    protected String postcode;
    protected String city;

    protected String country;
    protected int houseNumber;
    protected int discount;
    protected HashMap<String, String> extraGegevens;

    public Customer(String name, String street, String postcode, String city, String country, int houseNumber, int discount) {
        this.name = name;
        this.street = street;
        this.postcode = postcode;
        this.city = city;
        this.country = country;
        this.houseNumber = houseNumber;
        this.discount = discount;
        this.extraGegevens = new HashMap<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void addExtraGegeven(String type, String value) {
        this.extraGegevens.put(type, value);
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getDiscount() {
        return discount;
    }

    public void printCustomer(){
        Printer.printLine("Naam: " + this.name);
        Printer.printLine("Straat: " + this.street);
        Printer.printLine("Postcode: " + this.postcode);
        Printer.printLine("Stad: " + this.street);
        Printer.printLine("Land: " + this.country);
        Printer.printLine("Huisnummer: " + this.houseNumber);
        Printer.printLine("Kortingpercentage: " + this.discount);

        if(!this.extraGegevens.isEmpty()){
            Printer.printLine("Extra gegevens:");
            for (Map.Entry<String, String> entry : extraGegevens.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}

package Customer;

import DataInOut.*;

public class FoundationCustomer extends  Customer{
    private String foundation;

    public FoundationCustomer (String name, String street, String postcode, String city, String country, int houseNumber, int discount, String foundation){
        super(name, street, postcode, city, country, houseNumber,discount);
        this.foundation = foundation;
    }

    public String getFoundation() {
        return foundation;
    }

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    @Override
    public void printCustomer(){
        Printer.printLine("Stichting: " + this.foundation);
        super.printCustomer();
    }
}

package Customer;

import DataInOut.*;

public class FoundationCustomer extends  Customer{
    private String foundation;

    public FoundationCustomer(String name, String street, int houseNumber, String postcode, String city, String country, int discount, String foundation) {
        super(name, street, houseNumber, postcode, city, country, discount);
        this.foundation = foundation;
    }

    public String getFoundation() {
        return foundation;
    }

    @Override
    public void printCustomer(){
        Printer.getInstance().printLine("Stichting: " + this.foundation);
        super.printCustomer();
    }
}

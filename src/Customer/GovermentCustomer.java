package Customer;

import DataInOut.Printer;
public class GovermentCustomer extends Customer{
    private String ministry;

    public GovermentCustomer(String name, String street, int houseNumber, String postcode, String city, String country, int discount, String ministry) {
        super(name, street, houseNumber, postcode, city, country, discount);
        this.ministry = ministry;
    }

    public String getMinistry() {
        return ministry;
    }

    @Override
    public void printCustomer(){
        Printer.getInstance().printLine("Ministerie: " + this.ministry);
        super.printCustomer();
    }
}

package Customer;

import DataInOut.*;
public class GovermentCustomer extends Customer{
    private String ministry;

    public GovermentCustomer (String name, String street, String postcode, String city, int houseNumber, int discount ,String ministry){
        super(name, street, postcode, city, houseNumber,discount);
        this.ministry = ministry;
    }

    public String getMinisty() {
        return ministry;
    }

    public void setMinisty(String ministy) {
        this.ministry = ministy;
    }

    @Override
    public void printCustomer(){
        Printer.printLine("Ministerie: " + this.ministry);
        super.printCustomer();
    }
}

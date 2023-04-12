package Customer;


import DataInOut.*;

public class BusinessCustomer extends Customer {
    private String companyname;


    public BusinessCustomer(String name, String street, int houseNumber, String postcode, String city, String country, int discount, String companyname) {
        super(name, street, houseNumber, postcode, city, country, discount);
        this.companyname = companyname;
    }

    public String getCompany() {
        return companyname;
    }

    public void setCompany(String companyname) {
        this.companyname = companyname;
    }

    @Override
    public void printCustomer(){
        Printer.getInstance().printLine("Bedrijfsnaam: " + this.companyname);
        super.printCustomer();
    }
}
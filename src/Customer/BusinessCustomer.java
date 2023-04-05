package Customer;


import DataInOut.*;

public class BusinessCustomer extends Customer {
    private String companyname;



    public BusinessCustomer(String name, String street, String postcode, String city, int houseNumber, int discount, String companyname){
        super(name,street,postcode,city,houseNumber,discount);
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
        super.printCustomer();
        Printer.printLine("Bedrijfsnaam: " + this.companyname);
    }
}
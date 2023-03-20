class CustomerType {
    protected String name;
    protected String street;
    protected String postcode;
    protected String city;
    protected int houseNumber;

}

class BusinessCustomer extends CustomerType{
    // class company moet nog aangemaakt worden

    Company company;

    public BusinessCustomer(String name, String street, String postcode, String city, int houseNumber, Company company){
        this.name = name;
        this.street = street;
        this.postcode = postcode;
        this.city = city;
        this.houseNumber = houseNumber;
    }

}
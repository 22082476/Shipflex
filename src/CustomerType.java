class Customer {
    protected String name;
    protected String street;
    protected String postcode;
    protected String city;
    protected int houseNumber;
    protected int discount;


    public Customer(String name, String street, String postcode, String city, int houseNumber, int discount) {
        this.name = name;
        this.street = street;
        this.postcode = postcode;
        this.city = city;
        this.houseNumber = houseNumber;
        this.discount = discount;
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
        System.out.printf("Naam: %s%n", this.name);
        System.out.printf("Straat: %s%n", this.street);
        System.out.printf("Postcode: %s%n", this.postcode);
        System.out.printf("Stad: %s%n", this.city);
        System.out.printf("Huisnummer: %d%n", this.houseNumber);
    }
}

class BusinessCustomer extends Customer{
    // class company moet nog aangemaakt worden
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
        System.out.printf("Bedrijfsnaam: ", this.companyname);
    }
}

class GovermentCustomer extends Customer {

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
        super.printCustomer();
        System.out.printf("Ministerie: ", this.ministry);
    }
}

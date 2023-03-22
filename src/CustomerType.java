class Customer {
    protected String name;
    protected String street;
    protected String postcode;
    protected String city;
    protected int houseNumber;


    public Customer(String name, String street, String postcode, String city, int houseNumber) {
        this.name = name;
        this.street = street;
        this.postcode = postcode;
        this.city = city;
        this.houseNumber = houseNumber;
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
}

class BusinessCustomer extends Customer{
    // class company moet nog aangemaakt worden
    private Company company;


    public BusinessCustomer(String name, String street, String postcode, String city, int houseNumber,Company company){
        super(name,street,postcode,city,houseNumber);
        this.company = company;

    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}

class GovermentCustomer extends Customer {

    private String ministy;

    public GovermentCustomer (String name, String street, String postcode, String city, int houseNumber, String ministy){
        super(name, street, postcode, city, houseNumber);
        this.ministy = ministy;
    }

    public String getMinisty() {
        return ministy;
    }

    public void setMinisty(String ministy) {
        this.ministy = ministy;
    }
}

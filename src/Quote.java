public class Quote {
    private Company companyShipbuild;

    private Customer customer;
    private String Date;
    private String QuoteDate;
    private Boat boat;
    public double CalculateEnvironmentDiscount(Option optie) {
        return optie.getPrice() * optie.getEnvironmentDiscount();
    }

    public Quote(Company companyShipbuild){
        this.companyShipbuild = companyShipbuild;
    }

    public Quote(Company companyShipbuild, Customer customer){
    this(companyShipbuild);
    this.customer = customer;
    }

    public void setCompanyShipbuild(Company companyShipbuild) {
        this.companyShipbuild = companyShipbuild;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setQuoteDate(String quoteDate) {
        QuoteDate = quoteDate;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public Company getCompanyShipbuild() {
        return companyShipbuild;
    }

    public String getDate() {
        return Date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getQuoteDate() {
        return QuoteDate;
    }

    public Boat getBoat() {
        return boat;
    }
}

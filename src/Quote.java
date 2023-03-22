public class Quote {
    private Company companyShipbuild;

    private Customer customer;
    private String Date;
    private String QuoteDate;
    private Boat boat;

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
}

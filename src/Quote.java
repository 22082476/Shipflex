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

}

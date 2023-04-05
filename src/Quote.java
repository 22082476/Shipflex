public class Quote {
    private Company companyShipbuild;

    private Customer customer;
    private BusinessCustomer businessCustomer;
    private GovermentCustomer govermentCustomer;
    private FoundationCustomer foundationCustomer;
    private String Date;
    private String QuoteDate;
    private Boat boat;


    public Quote(Company companyShipbuild, Boat boat) {
        this.companyShipbuild = companyShipbuild;
        this.businessCustomer = null;
        this.customer = null;
        this.govermentCustomer = null;
        this.foundationCustomer = null;
        this.boat = boat;
    }


    public void setCompanyShipbuild(Company companyShipbuild) {
        this.companyShipbuild = companyShipbuild;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setBusinessCustomer(BusinessCustomer businessCustomer) {
        this.businessCustomer = businessCustomer;
    }

    public void setGovermentCustomer(GovermentCustomer govermentCustomer) {
        this.govermentCustomer = govermentCustomer;
    }

    public void setFoundationCustomer(FoundationCustomer foundationCustomer) {
        this.foundationCustomer = foundationCustomer;
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

    public void printCustomer() {
        if (govermentCustomer != null) {
            govermentCustomer.printCustomer();
        } else if (businessCustomer != null) {
            businessCustomer.printCustomer();
        } else if (customer != null) {
            customer.printCustomer();
        } else if (foundationCustomer != null) {
            foundationCustomer.printCustomer();
        } else {
            Printer.printLine("Nog geen klant toegevoegd");
        }
    }

    public void printOptions() {
        for (Option option : this.boat.getOptions()) {
            Info.printOptionInfo(option, -1);
        }
    }

    public void printBasicInformation() {
        companyShipbuild.getName();
        companyShipbuild.getStreet();
        companyShipbuild.getHousenumber();
        companyShipbuild.getPostcode();
        companyShipbuild.getCity();


        if (customer != null) {
            customer.getName();
            customer.getStreet();
            customer.getHouseNumber();
            customer.getPostcode();
            customer.getCity();
        } else if (businessCustomer != null) {
            businessCustomer.getName();
            businessCustomer.getStreet();
            businessCustomer.getHouseNumber();
            businessCustomer.getPostcode();
            businessCustomer.getCity();
        } else if (govermentCustomer != null) {
            govermentCustomer.getName();
            govermentCustomer.getStreet();
            govermentCustomer.getHouseNumber();
            govermentCustomer.getPostcode();
            govermentCustomer.getCity();
        } else if (foundationCustomer != null) {
            foundationCustomer.getName();
            foundationCustomer.getFoundation();
            foundationCustomer.getStreet();
            foundationCustomer.getHouseNumber();
            foundationCustomer.getPostcode();
            foundationCustomer.getCity();
        } else {
            Printer.printLine("Nog geen klant toegevoegd");
        }

        boat.getName();
        boat.getType();
        boat.getBasePrice();
        boat.getOptions();
    }
}

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
        printBasicInformation();
    }

    public void printBasicInformation() {

        companyShipbuild.getName();
        companyShipbuild.getStreet();
        companyShipbuild.getHousenumber();
        companyShipbuild.getPostcode();
        companyShipbuild.getCity();
        Printer.printLine(companyShipbuild.getName());
        Printer.print(companyShipbuild.getStreet());
        Printer.print(String.valueOf(companyShipbuild.getHousenumber()));
        Printer.printLine(String.valueOf(companyShipbuild.getPostcode()));
        Printer.printLine(companyShipbuild.getCity());



        if (customer != null) {
            Printer.printLine(customer.getName());
            Printer.print(customer.getStreet());
            Printer.print(String.valueOf(customer.getHouseNumber()));
            Printer.printLine(String.valueOf(customer.getPostcode()));
            Printer.printLine(customer.getCity());
        } else if (businessCustomer != null) {
            Printer.printLine(businessCustomer.getName());
            Printer.print(businessCustomer.getStreet());
            Printer.print(String.valueOf(businessCustomer.getHouseNumber()));
            Printer.printLine(String.valueOf(businessCustomer.getPostcode()));
            Printer.printLine(businessCustomer.getCity());
        } else if (govermentCustomer != null) {
            Printer.printLine(govermentCustomer.getName());
            Printer.print(govermentCustomer.getStreet());
            Printer.print(String.valueOf(govermentCustomer.getHouseNumber()));
            Printer.printLine(String.valueOf(govermentCustomer.getPostcode()));
            Printer.printLine(govermentCustomer.getCity());
        } else if (foundationCustomer != null) {
            Printer.printLine(foundationCustomer.getName());
            Printer.print(foundationCustomer.getStreet());
            Printer.print(String.valueOf(foundationCustomer.getHouseNumber()));
            Printer.printLine(String.valueOf(foundationCustomer.getPostcode()));
            Printer.printLine(foundationCustomer.getCity());
        } else {
            Printer.printLine("Nog geen klant toegevoegd");
        }

        Printer.printLine(boat.getName());
        Printer.printLine(boat.getType());
        Printer.print(String.valueOf(boat.getBasePrice()));
        Printer.printLine(String.valueOf(boat.getOptions()));
    }
}

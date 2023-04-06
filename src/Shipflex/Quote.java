package Shipflex;

import Boat.*;
import Customer.*;
import DataInOut.*;


public class Quote {
    private Company companyShipbuild;

    private Customer customer;
    private BusinessCustomer businessCustomer;
    private GovermentCustomer govermentCustomer;
    private FoundationCustomer foundationCustomer;
    private String Date;
    private String QuoteDate;
    private String about;
    private Boat boat;


    public Quote(Company companyShipbuild, Boat boat) {
        this.companyShipbuild = companyShipbuild;
        this.businessCustomer = null;
        this.customer = null;
        this.govermentCustomer = null;
        this.foundationCustomer = null;
        this.boat = boat;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
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

    public BusinessCustomer getBusinessCustomer() {
        return businessCustomer;
    }

    public GovermentCustomer getGovermentCustomer() {
        return govermentCustomer;
    }

    public FoundationCustomer getFoundationCustomer() {
        return foundationCustomer;
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

    public void printOptions(boolean showIndex) {
        for (Option option : this.boat.getOptions()) {
            if(showIndex)
                Info.printOptionInfo(option, Info.getOptions().indexOf(option));
            else
                Info.printOptionInfo(option, -1);
        }
    }


    public void printDate(){
        Printer.printLine("Datum: " + this.Date);
        Printer.printLine("Geldigsheid datum: " + this.QuoteDate);
    }


    public void printBasicInformation() {
        companyShipbuild.printCompany();
        Printer.emptyLine();
        printCustomer();
        Printer.emptyLine();
        printDate();
        Printer.emptyLine();
        Printer.printLine("Betreft: " + this.about);
        Printer.emptyLine();
    }

    public void printQuote(){
        printBasicInformation();
        boat.printBoat();
        printOptions(false);
        printTotal();
    }

    public void printTotal() {
        double totalPrice = 0;

        for (Option option : boat.getOptions()) {
            totalPrice += option.getPrice();
        }
        Printer.printLine("Totaal prijs:" + totalPrice);
        Printer.printLine("Totaal prijs inclusief BTW " + totalPrice *1.21);
    }
}

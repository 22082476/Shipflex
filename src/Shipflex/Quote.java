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
    private String date;
    private String quoteDate;
    private String about;

    private double workHoursCost;
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
        this.date = date;
    }

    public void setQuoteDate(String quoteDate) {
        this.quoteDate = quoteDate;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public Company getCompanyShipbuild() {
        return companyShipbuild;
    }

    public String getDate() {
        return date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getQuoteDate() {
        return quoteDate;
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

    public double getWorkHoursCost() {
        return workHoursCost;
    }

    public void setWorkHoursCost(double workHoursCost) {
        this.workHoursCost = workHoursCost;
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
            Printer.getInstance().printLine("Nog geen klant toegevoegd");
        }
    }

    public void printOptions(boolean showIndex) {
        for (Option option : this.boat.getOptions()) {
            if(showIndex)
                Info.printOptionInfo(option, Info.getOptions().indexOf(option));
            else
                Info.printOptionInfo(option, -1);

            Printer.getInstance().emptyLine();
        }
    }

    public void printCompany(){
        Printer.getInstance().printLine(companyShipbuild.getName());
        Printer.getInstance().print(companyShipbuild.getStreet());
        Printer.getInstance().print(String.valueOf(companyShipbuild.getHousenumber()));
        Printer.getInstance().printLine(String.valueOf(companyShipbuild.getPostcode()));
        Printer.getInstance().printLine(companyShipbuild.getCity());
    }

    public void printDate() {
        if (this.date != null && !this.date.equals("")) {
            Printer.getInstance().printLine("Datum: " + this.date);
        } else {
            Printer.getInstance().printLine("Datum nog niet ingevuld");
    }
        if(this.quoteDate != null && !this.quoteDate.equals("")){
            Printer.getInstance().printLine("Geldigsheid datum: " + this.quoteDate);
        } else {
            Printer.getInstance().printLine("Geldigsheid datum nog niet ingevuld");
        }

    }


    public void printBasicInformation() {
        companyShipbuild.printCompany();
        Printer.getInstance().emptyLine();
        printCustomer();
        Printer.getInstance().emptyLine();
        printDate();
        Printer.getInstance().emptyLine();

        if(this.about != null && !this.about.equals("")) {
            Printer.getInstance().printLine("Betreft: " + this.about);
        }else {
            Printer.getInstance().printLine("Betreft is nog niet ingevuld");
        }
        Printer.getInstance().emptyLine();
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
        Printer.getInstance().printLine("Totaal prijs:" + totalPrice);
        Printer.getInstance().printLine("Totaal prijs inclusief BTW " + totalPrice *1.21);
    }
}

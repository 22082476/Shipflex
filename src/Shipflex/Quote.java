package Shipflex;

import Boat.*;
import Customer.*;
import DataInOut.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


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
        switch (checkCustomerType()){
            case "goverment":
                govermentCustomer.printCustomer();
                break;
            case "business":
                businessCustomer.printCustomer();
                break;
            case "foundation":
                foundationCustomer.printCustomer();
                break;
            case "customer":
                customer.printCustomer();
                break;
            default:
                Printer.printLine("Nog geen klant toegevoegd");
                break;
        }
    }

    private String checkCustomerType(){
        if (govermentCustomer != null) {
            return "goverment";
        } else if (businessCustomer != null) {
            return "business";
        } else if (customer != null) {
            return "customer";
        } else if (foundationCustomer != null) {
           return  "foundation";
        }else {
            return null;
        }
    }

    public void printOptions(boolean showIndex) {
        for (Option option : this.boat.getOptions()) {
            if (showIndex)
                Info.printOptionInfo(option, Info.getOptions().indexOf(option));
            else
                Info.printOptionInfo(option, -1);

            Printer.emptyLine();
        }
    }

    public void printCompany() {
        Printer.printLine(companyShipbuild.getName());
        Printer.print(companyShipbuild.getStreet());
        Printer.print(String.valueOf(companyShipbuild.getHousenumber()));
        Printer.printLine(String.valueOf(companyShipbuild.getPostcode()));
        Printer.printLine(companyShipbuild.getCity());
    }

    public void printDate() {
        if (this.date != null && !this.date.equals("")) {
            Printer.printLine("Datum: " + this.date);
        } else {
            Printer.printLine("Datum nog niet ingevuld");
    }
        if(this.quoteDate != null && !this.quoteDate.equals("")){
            Printer.printLine("Geldigsheid datum: " + this.quoteDate);
        } else {
            Printer.printLine("Geldigsheid datum nog niet ingevuld");
        }

    }


    public void printBasicInformation() {
        companyShipbuild.printCompany();
        Printer.emptyLine();
        printCustomer();
        Printer.emptyLine();
        printDate();
        Printer.emptyLine();

        if(this.about != null && !this.about.equals("")) {
            Printer.printLine("Betreft: " + this.about);
        }else {
            Printer.printLine("Betreft is nog niet ingevuld");
        }
        Printer.emptyLine();
    }

    public void printQuote() {
        printBasicInformation();
        boat.printBoat();
        Printer.emptyLine();
        printOptions();
        Printer.emptyLine();
        printTotal();
    }

    public void printOptions() {
        List<Option> essentialOptions = new ArrayList<>();
        List<Option> extraOptions = new ArrayList<>();

        for (Option option : boat.getOptions()) {
            if(option.getEssentialForBoatType().contains(boat.getType().toLowerCase()))
                essentialOptions.add(option);
            else
                extraOptions.add(option);
        }

        printOptionsListFormatted(essentialOptions);
        printOptionsListFormatted(extraOptions);
    }

    private void printOptionsListFormatted(List<Option> options) {
        for(Option option : options) {
            option.printOptionInfoForBoat(boat.getType());
        }
    }

    public int getDiscount() {
        int discount = 0;
        switch (checkCustomerType()) {
            case "goverment":
                discount = govermentCustomer.getDiscount();
                break;
            case "business":
                discount = businessCustomer.getDiscount();
                break;
            case "foundation":
                discount = foundationCustomer.getDiscount();
                break;
            case "customer":
                discount = customer.getDiscount();
                break;
        }
        return 100 - discount;
    }


    public double calculatePercentage(int percentage, double price) {
        return (price/100) * percentage;
    }

    public double calculateBoatPrice(){
        double price = 0;
        price += boat.getBasePrice();

        for (Option option : boat.getOptions()) {
            price += option.getPrice();
        }

        return price;
    }

    public void printTotal() {
        double workCost = workHoursCost;
        Printer.printLine(String.format("Prijs arbeids uren: %.2f", workCost));
        workCost = calculatePercentage(109, workCost);
        Printer.printLine(String.format("Prijs arbeids uren incl. Btw: %.2f", workCost));

        double totalPriceBoat = calculateBoatPrice();
        Printer.printLine(String.format("Totaal prijs boot: %.2f", totalPriceBoat));
        if(getDiscount() < 100 && getDiscount() > 0) {
            totalPriceBoat = calculatePercentage(getDiscount(), totalPriceBoat);
            Printer.printLine(String.format("Totaal prijs boot met korting: %.2f", totalPriceBoat));
        }

        totalPriceBoat = calculatePercentage(121, totalPriceBoat);
        Printer.printLine(String.format("Totaal prijs boot incl. Btw: %.2f", totalPriceBoat));

    }
}

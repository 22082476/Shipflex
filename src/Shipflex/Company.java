package Shipflex;

import DataInOut.Printer;

public class Company {
    private String name;
    private String street;

    private int housenumber;
    private String postcode;
    private String city;

    private String country;


    public Company(String name, String street, int housenumber, String postcode, String city, String country){
        this.name = name;
        this.street = street;
        this.housenumber = housenumber;
        this.postcode = postcode;
        this.city = city;
        this.country = country;
    }

     public String getName() {
         return this.name;
     }

     public String getStreet() {
         return this.street;
     }

     public String getPostcode() {
         return this.postcode;
     }

     public String getCity() {
         return this.city;
     }

     public int getHousenumber() {
         return this.housenumber;
     }

    public String getCountry() {
        return country;
    }

    public void printCompany(){
        Printer.getInstance().printLine(getName());
        Printer.getInstance().printLine(getStreet() + " " + getHousenumber());
        Printer.getInstance().printLine(""+ getPostcode());
        Printer.getInstance().printLine(getCity());
        Printer.getInstance().printLine(getCountry());
    }
 }

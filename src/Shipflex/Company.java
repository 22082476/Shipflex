package Shipflex;

import DataInOut.Printer;

public class Company {
    private String name;
    private String street;
    private String postcode;
    private String city;

    private String country;
    private int housenumber;

    public Company(String name, String street, String postcode, String city, String country, int housenumber){
        this.name = name;
        this.street = street;
        this.postcode = postcode;
        this.city = city;
        this.country = country;
        this.housenumber = housenumber;
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

     public void setHousenumber(int housenumber) {
         this.housenumber = housenumber;
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

    public void setCountry(String country) {
        this.country = country;
    }

    public void printCompany(){
        Printer.getInstance().printLine(getName());
        Printer.getInstance().printLine(getStreet() + " " + getHousenumber());
        Printer.getInstance().printLine(""+ getPostcode());
        Printer.getInstance().printLine(getCity());
        Printer.getInstance().printLine(getCountry());
    }
 }

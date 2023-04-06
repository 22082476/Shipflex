package Shipflex;

import Boat.*;
import Customer.*;
import DataInOut.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MakeQuote {

    protected Quote quote;


    public MakeQuote(String boatType, Company company){
        this.quote = new Quote(company, getFromTypeBoat(boatType));
    }


    public void start(){
        askBasicInfo();

        while(true) {
            printTextGenerateQuote();
            int inputIndex = ScanInput.scanInt();

            switch (inputIndex) {
                case 0:
                    return;
                case 1, 2:
                    Printer.emptyLine();
                    askCustomer();
                    break;
                case 3:
                    quote.printCustomer();
                    break;
               case 4:
                   Printer.emptyLine();
                    Info.printOptionsForBoatType(quote.getBoat().getType());
                    break;
               case 5:
                    quote.printOptions(false);
                    Printer.emptyLine();
                    break;
                case 6:
                    Printer.emptyLine();
                    selectOption();
                    break;
                case 7:
                    quote.printQuote();
                    break;
                case 8:
                    askBasicInfo();
                    break;
                case 9:
                    Printer.emptyLine();
                    quote.printBasicInformation();
                    break;
                case 10:
                    removeOptionFromBoat();
                    break;
                case 11:
                    askWorkHours();
                    break;
                case 10:
                    quote.setWorkhours(ScanInput.inputNumber("de arbeidsuren"));
                    break;
                default:
                    Printer.emptyLine();
                    Printer.printLine("Incorrecte invoer!");
                    Printer.printLine("probeer opniew");
            }

        }
    }

    public void askBasicInfo(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        quote.setDate(sdf.format(date));
        quote.setQuoteDate(ScanInput.inputQuestion("de geldigheids datum voor de offerte(dd-mm-yyyy)"));
        quote.setAbout(ScanInput.inputQuestion("de betreft"));
        Printer.emptyLine();
    }

    private void printTextGenerateQuote(){
        String [] input = {"terug", "voeg klant toe", "wijzig klant", "laat klant zien", "beschikbare opties", "gekozen opties", "voeg optie toe", "offerte printen", "basis gegevens wijzigen", "basisgegevens laten zien", "optie weghalen", "Voeg arbeidsuren toe"};

        Printer.print("Commands: ");
        for(int i = 0; i < input.length; i++){
            if(i == input.length-1){
                Printer.printLine("[" +i+ "] " + input[i]);
            }else {
                Printer.print("[" +i+ "] " + input[i] + ", ");
            }

            if (i == input.length / 2)
                Printer.emptyLine();
        }
        Printer.print("Voer een command in: ");
    }


    private Boat getFromTypeBoat(String boatType){
        switch (boatType){
            case "plezierjacht":
                return new PleasureYacht();
            case "rubberboot":
                return new InflatableBoat();
            case "speedboot":
                return new SpeedBoat();
            case "zeilboot":
                return new SailBoat();
            default:
                return null;
        }
}















    public void askWorkHours(){
        int hour = ScanInput.inputNumber("de arbeidsuren");
        double workHours = hour * ScanInput.inputNumberD("voer uurtarief");
        quote.setWorkhours(workHours);


    }
}

package Shipflex;

import Boat.*;

import DataInOut.*;
import static DataInOut.Printer.printTextGenerateQuote;

public class MakeQuote {

    protected static Quote quote;
    private String [] commands = {"terug", "algemeen", "klant", "boot"};



    public MakeQuote(String boatType, Company company){
        this.quote = new Quote(company, getFromTypeBoat(boatType));
    }


    public void start(){
         while(true) {
            printTextGenerateQuote(commands);
            int inputIndex = ScanInput.scanInt();

            switch (inputIndex) {
                case 0:
                    return;
                case 1:
                    Printer.emptyLine();
                    MakeQuoteGeneral makeQuoteGeneral = new MakeQuoteGeneral();
                    makeQuoteGeneral.start();
                    break;
                case 2:
                    Printer.emptyLine();
                    MakeQuoteCustomer makeQuoteCustomer = new MakeQuoteCustomer();
                    makeQuoteCustomer.start();
                    break;
                case 3:
                    Printer.emptyLine();
                    MakeQuoteBoat makeQuoteBoat = new MakeQuoteBoat();
                    makeQuoteBoat.start();
                    break;
                default:
                    Printer.emptyLine();
                    Printer.printLine("Incorrecte invoer!");
                    Printer.printLine("probeer opniew");
            }

        }
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
}

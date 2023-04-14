package Shipflex;

import Boat.Boat;
import Boat.InflatableBoat;
import Boat.SailBoat;
import Boat.PleasureYacht;
import Boat.SpeedBoat;

import DataInOut.ScanInput;
import DataInOut.Printer;

public class   MakeQuote {

    protected static Quote quote;
    private String [] commands = {"terug", "algemeen", "klant", "boot", "offerte printen"};



    public MakeQuote(String boatType, Company company){
        Boat boat = getFromTypeBoat(boatType);
        while (boat == null) {
            Printer.getInstance().printLine("Incorrecte invoer!");
            boat = getFromTypeBoat(ScanInput.inputQuestion("het boottype (rubberboot, zeilboot, speedboot, plezierjacht)"));
        }
        this.quote = new Quote(company, boat);
    }
    public static Quote getQuote() {
        return quote;
    }

    public void start(){
        Printer.getInstance().emptyLine();
         while(true) {
            Printer.getInstance().printTextGenerateQuote(commands);
            int inputIndex = ScanInput.inputNumber("command");
             Printer.getInstance().emptyLine();
            switch (inputIndex) {
                case 0:
                    return;
                case 1:
                    MakeQuoteGeneral makeQuoteGeneral = new MakeQuoteGeneral();
                    makeQuoteGeneral.start();
                    break;
                case 2:
                    MakeQuoteCustomer makeQuoteCustomer = new MakeQuoteCustomer();
                    makeQuoteCustomer.start();
                    break;
                case 3:
                    MakeQuoteBoat makeQuoteBoat = new MakeQuoteBoat();
                    makeQuoteBoat.start();
                    break;
                case 4:
                    quote.printQuote();
                    break;
                default:
                    Printer.getInstance().printLine("Incorrecte invoer!");
                    Printer.getInstance().printLine("probeer opniew");
            }
             Printer.getInstance().emptyLine();
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

package Shipflex;

import DataInOut.*;

import static DataInOut.ScanInput.inputNumber;


public class Shipflex {
    private static Company company = new Company("Scheeps werf den haag", "boatstraat", "2000 EA", "Den haag", 14);

    public static void main(String[] args) {
        Info.readOptionsFromFile("src/data/options.csv");
        welcomeText();
        while (true) {
            startText();
            int inputIndex = inputNumber("een command");
            Printer.emptyLine();
            switch (inputIndex) {
                case 0:

                    System.exit(0);
                    break;
                case 1:
                    startMakeQuote();
                    break;
                case 2:
                    startMaintenance();
                    break;
                default:
                    Printer.printLine("Incorrecte invoer!");
            }
            Printer.emptyLine();
        }
    }

    public static void welcomeText(){
        //standaard welcome tekst
        Printer.printLine("Welcome by shipflex");
    }

    public static void startText(){
        Printer.printLine("Commands: [0] stop, [1] maak offerte, [2] onderhoud");
    }

    public static void startMakeQuote(){
        Printer.print("Voer het boot type in (rubberboot, zeilboot, speedboot, plezierjacht): ");
        MakeQuote makeQuote = new MakeQuote(ScanInput.scanInL(), company);
        makeQuote.start();
    }

    public static void startMaintenance(){
        Maintenance maintenance = new Maintenance();
        maintenance.start();
    }
}

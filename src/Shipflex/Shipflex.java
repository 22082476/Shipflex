package Shipflex;

import DataInOut.Printer;
import DataInOut.Info;
import DataInOut.ScanInput;

import static DataInOut.ScanInput.inputNumber;


public class Shipflex {
    private static Company company = new Company("Scheeps werf Den haag", "Boatstraat", 14, "2000 EA", "Den haagq1","Nederland");

    private static String [] commands = {"stop", "maak offerte", "onderhoud"};

    public static void main(String[] args) {
        Info.readOptionsFromFile("src/data/options.csv");
        welcomeText();
        while (true) {
            Printer.getInstance().printTextGenerateQuote(commands);
            int inputIndex = inputNumber("command");
            Printer.getInstance().emptyLine();
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
                    Printer.getInstance().printLine("Incorrecte invoer!");
            }
            Printer.getInstance().emptyLine();
        }
    }

    public static void welcomeText(){
        //standaard welcome tekst
        Printer.getInstance().printLine("Welcome by shipflex");
        Printer.getInstance().emptyLine();

    }
    public static void startMakeQuote(){
        MakeQuote makeQuote = new MakeQuote(ScanInput.inputQuestion("het boottype (rubberboot, zeilboot, speedboot, plezierjacht)"), company);
        makeQuote.start();
    }

    public static void startMaintenance(){
        Maintenance maintenance = new Maintenance();
        maintenance.start();
    }
}

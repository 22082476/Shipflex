package Shipflex;

import Boat.Option;
import DataInOut.Info;
import DataInOut.Printer;
import DataInOut.ScanInput;

import java.util.ArrayList;
import java.util.Arrays;

public class Maintenance {
    private String [] commands = {"terug", "optie toevoegen"};

    public void start() {
        while (true) {
            Printer.getInstance().printTextGenerateQuote(commands);
            int inputIndex = ScanInput.inputNumber("command");
            Printer.getInstance().emptyLine();
            switch (inputIndex) {
                case 0:
                    return;
                case 1:
                    addOptionMaintenance();
                    break;

                default:
                    Printer.getInstance().printLine("Incorrecte invoer!");
            }
        }
    }

    public ArrayList<String> parseBoatTextToList(String question) {
        String userInput = ScanInput.inputQuestion(question);

        String[] boatTypes = userInput.split(",|, "); // Split de input zodat de boat types individueel worden opgeslagen en niet in 1 string

        ArrayList<String> boatList = new ArrayList<>(Arrays.asList(boatTypes)); // Voeg ze toe aan de arraylist

        return boatList;
    }

    public void addOptionMaintenance(){
        Info.addOption(new Option(
                ScanInput.inputQuestion("de naam van het onderdeel"),
                ScanInput.inputNumberD("de prijs (bijv. 2.99) van het onderdeel"),
                ScanInput.inputQuestion("categorie van onderdeel"),
                0,
                parseBoatTextToList("de boten in waarvoor het onderdeel essentieel is (bijv: rubberboot, plezierjacht)"),
                parseBoatTextToList("de boten in waarvoor het onderdeel optioneel is (bijv: rubberboot, plezierjacht)")));
    }
}


package Shipflex;

import Boat.Option;
import DataInOut.Info;
import DataInOut.Printer;
import DataInOut.ScanInput;

import java.util.ArrayList;

public class Maintenance {
    private ArrayList<String> boatList = new ArrayList<>();

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

    public ArrayList<String> readTypeBoatList(String question) {
        String userInput = ScanInput.inputQuestion(question);

        if(!userInput.equalsIgnoreCase("stop")) {
            if (!boatList.equals("")) {
                boatList.add(userInput);
                readTypeBoatList(question);
            }
        }

        return boatList;
    }

        public void addOptionMaintenance(){
            Info.addOption(new Option(ScanInput.inputQuestion("de naam van het onderdeel"),
            ScanInput.inputNumberD("de prijs (bijv. 2.99) van het onderdeel"),
            ScanInput.inputQuestion("categorie van onderdeel"),
            0,
            readTypeBoatList("de boot in waarvoor de onderdeel essentieel is (stop om door te gaan)"),
            readTypeBoatList("de boot in waarvoor de onderdeel optioneel is (stop om door te gaan)")));
            }
}


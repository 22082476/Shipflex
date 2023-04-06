package Shipflex;

import Boat.*;
import DataInOut.Info;
import DataInOut.ScanInput;

import java.util.ArrayList;

public class Maintenance {
    private ArrayList<String> boatList = new ArrayList<>();

    public ArrayList<String> readBoatList(String question) {
        String userInput = ScanInput.inputQuestion(question);

        if(!userInput.equalsIgnoreCase("stop")) {
            if (!boatList.equals("")) {
                boatList.add(userInput);
                readBoatList(question);
            }
        }

        return boatList;
    }
    public void start(){
        String input;
        input = ScanInput.inputQuestion("optie toevoegen of customer type toevoegen");

        if(input.equalsIgnoreCase("optie toevoegen")) {
            Info.addOption(new Option(ScanInput.inputQuestion("de naam van het onderdeel"),
            ScanInput.inputNumberD("de prijs (bijv. 2.99) van het onderdeel"),
            ScanInput.inputQuestion("categorie van onderdeel"),
            0,
            readBoatList("de boot in waarvoor de onderdeel essentieel is (stop om door te gaan)"),
            readBoatList("de boot in waarvoor de onderdeel optioneel is (stop om door te gaan)")));
        }
    }
}

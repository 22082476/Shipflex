package Shipflex;

import Boat.*;
import DataInOut.Info;
import DataInOut.ScanInput;

import java.util.ArrayList;

public class Maintenance {


    public ArrayList<String> readBoatList(String question) {
        ArrayList boatList = new ArrayList();
        String userinput = ScanInput.inputQuestion(question);
        if(!userinput.equalsIgnoreCase("stop")) {
            if (!boatList.equals("")) {
                boatList.add(userinput);
                readBoatList(question);
            }
        }
        return boatList;
    }
    public void start(){
        String input;
        input = ScanInput.inputQuestion(" optie toevoegen of customer type toevoegen");

        if(input.equalsIgnoreCase("optie toevoegen")) {
            Info.addOption(new Option(ScanInput.inputQuestion("de naam van het onderdeel"),
            ScanInput.inputNumber("de prijs van het onderdeel"),
            ScanInput.inputQuestion("soort van onderdeel"),
            ScanInput.inputNumber("het kortingsperctentage"),
            readBoatList("voor welke soort boten het onderdeel essentieel is"),
            readBoatList("voor welke soort boten het onderdeel optioneel is")));
        }
    }
}

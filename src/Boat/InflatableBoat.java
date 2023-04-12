package Boat;

import DataInOut.Info;
import DataInOut.Printer;

public class InflatableBoat extends Boat{

    private String[] optionNames = {"peddel", "reddingsvest"};

    public InflatableBoat() {
        super("Rubberboot", "Rubberboot", 2499.99);
        super.addOptionsFromNames(optionNames);
    }
}

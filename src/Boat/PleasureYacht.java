package Boat;

public class PleasureYacht extends Boat{

    private String[] optionNames = {"snelheidsmeter", "parapluanker", "binnenverlichting", "roerarm", "yamaha"};

    public PleasureYacht() {
        super("Plezierjacht", "Plezier jacht", 12999.99);
        super.addOptionsFromNames(optionNames);
    }
}

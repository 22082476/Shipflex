package Boat;

public class PleasureYacht extends Boat{

    private String[] optionNames = {"snelheidsmeter", "parapluanker", "binnenverlichting", "roerarm", "yamaha"};

    public PleasureYacht() {
        super("Plezier Jacht", "plezierjacht", 12999.99);
        super.addOptionsFromNames(optionNames);
    }
}

package Boat;

public class SpeedBoat extends Boat {

    private String[] optionNames = {"snelheidsmeter", "dodemanskoord", "binnenverlichting", "roerarm", "yamaha"};
    public SpeedBoat() {
        super("Speedboot", "Speedboot", 24999.99 );
        super.addOptionsFromNames(optionNames);
    }

}

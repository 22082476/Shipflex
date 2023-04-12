package Boat;

public class SpeedBoat extends Boat {

    String[] optionNames = {"snelheidsmeter", "dodemanskoord", "binnenverlichting", "roerarm", "yamaha"};
    public SpeedBoat() {
        super("Speedboot", "Speedboot", 24999.99 );
        super.addOptionsFromNames(optionNames);
    }

}

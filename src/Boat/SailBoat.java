package Boat;

public class SailBoat extends Boat {

    String[] optionNames = {"kevlar", "touw", "binnenverlichting", "roerarm", "yamaha"};

    public SailBoat() {
        super("zeilboot", "zeilboot", 2999.99 );
        super.addOptionsFromNames(optionNames);
    }
}

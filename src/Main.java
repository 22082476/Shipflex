public class Main {
    public static void main(String[] args){
        //Console console = new Console();
        //console.startQuoteBuilder();
        ShipBuilder shipBuilder = new ShipBuilder();

        Info file = new Info();
        file.readOptionsFromFile("src\\data\\test.csv");

        for(Option option : file.getOptions()) {
            System.out.println("Naam: " + option.getName() + " Boats: " + option.getEssentialForBoatTypes());
        }
    }
}

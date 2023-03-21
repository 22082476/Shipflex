public class Main {
    public static void main(String[] args){
        //Console console = new Console();
        //console.startQuoteBuilder();
        ShipBuilder shipBuilder = new ShipBuilder();

        DefaultOptions file = new DefaultOptions();
        file.initOptions("src\\data\\test.csv", shipBuilder);

        for(Option option : shipBuilder.getAvailableOptions()) {
            System.out.println("Naam: " + option.getName() + " Prijs: " + option.getPrice() + " Discount: " + option.isEnvironmentDiscount() + " Description: " + option.getDescription());
        }
    }
}

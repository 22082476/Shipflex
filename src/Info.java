import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Info {

    // hier moet nog een customer en company list
    private static ArrayList<Option> options;

    Info() {
        this.options = new ArrayList<>();
    }

    public static void readOptionsFromFile(String filePath) {

        String line = "";
        boolean isFirstLine = true;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            while((line = br.readLine()) != null) {

                if(isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] row = line.split(",");
                String[] essentialBoatTypes = row[4].split(";");
                String[] extraForBoatTypes = row[5].split(";");

                double price = Double.parseDouble(row[1]);
                int environmentDiscount = Integer.parseInt(row[3]);

                if(row.length > 6)
                    addOption(new Option(row[0], price, row[2], environmentDiscount, new ArrayList<>(List.of(essentialBoatTypes)), new ArrayList<>(List.of(extraForBoatTypes)), row[6]));
                else
                    addOption(new Option(row[0], price, row[2], environmentDiscount, new ArrayList<>(List.of(essentialBoatTypes)), new ArrayList<>(List.of(extraForBoatTypes))));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Option> getOptions() {
        return options;
    }

    public static void addOption(Option option) {
        options.add(option);
    }

    public static void printOptionsForBoatType(String boatType) {
        boolean essential = false;
        boolean extra = false;
        boolean foundEssentialOption = false;
        boolean foundExtraOption = false;

        // Loop door essentiele en extra opties, check of het past bij de gegeven boat type en dan pas uitprinten
        for(Option option : options) {

            // Zorg ervoor dat dit maar 1x wordt geprint
            if(!essential) {
                System.out.println("[ESSENTIAL OPTIONS]");
                essential = true;
            }

            for(String boat : option.getEssentialForBoatType()) {
                if(!boat.equalsIgnoreCase(boatType))
                    continue;

                foundEssentialOption = true;
                printOptionInfo(option);
                System.out.println();
            }

            if(!extra) {
                System.out.println("[ESSENTIAL OPTIONS]");
                extra = true;
            }

            for(String boat : option.getExtraForBoatType()) {
                if(!boat.equalsIgnoreCase(boatType))
                    continue;

                foundExtraOption = true;
                printOptionInfo(option);
                System.out.println();
            }
        }

        if(!foundEssentialOption)
            System.out.println("Geen essentiele opties gevonden voor boot type " + boatType);

        if(!foundExtraOption)
            System.out.println("Geen extra opties gevonden voor boot type " + boatType);
    }

    public static void printOptionInfo(Option option) {
        System.out.println("Option: " + option.getName());
        System.out.println("Type: " + option.getType() + " Price: " + option.getPrice() + " Environment discount percentage: " + option.getEnvironmentDiscount());

        if(option.calculateEnvironmentDiscount() != option.getPrice())
            System.out.println("Price w/ discount: " + option.calculateEnvironmentDiscount());

        if(option.getDescription() != null)
            System.out.println("Description: " + option.getDescription());
    }
}

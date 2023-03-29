import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Info {

    // hier moet nog een customer en company list
    private static ArrayList<Option> options = new ArrayList<>();;

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

            // Sorteer alles op de categorie in de arraylist (zit nu alfabetisch met elkaar in de array)
            Collections.sort(options, Comparator.comparing(Option::getType));

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

    public static ArrayList<Integer> printOptionsForBoatType(String boatType) {
        boolean foundEssentialOption = false;
        boolean foundExtraOption = false;
        int index = 0;
        ArrayList<Integer> validOptionsIndexes = new ArrayList();

        // Misschien een betere manier om de essentiele en extra opties te printen ipv 2 loops?

        // Loop door essentiele en extra opties, check of het past bij de gegeven boat type en dan pas uitprinten
        System.out.println("[ESSENTIAL OPTIONS]");
        for(Option option : options) {
            for (String boat : option.getEssentialForBoatType()) {
                if (!boat.equalsIgnoreCase(boatType))
                    continue;

                foundEssentialOption = true;
                printOptionInfo(option, index);
                validOptionsIndexes.add(index);
                System.out.println();
            }

            index++;
        }

        if(!foundEssentialOption)
            System.out.println("Geen essentiele opties gevonden voor boot type " + boatType);

        index = 0; // Reset index om de juiste te krijgen voor de volgende loop

        System.out.println("[EXTRA OPTIONS]");
        for(Option option : options) {
            for(String boat : option.getExtraForBoatType()) {
                if(!boat.equalsIgnoreCase(boatType))
                    continue;

                foundExtraOption = true;
                printOptionInfo(option, index);
                validOptionsIndexes.add(index);
                System.out.println();
            }

            index++;
        }

        if(!foundExtraOption)
            System.out.println("Geen extra opties gevonden voor boot type " + boatType);

        return validOptionsIndexes;
    }

    public static void printOptionInfo(Option option, int index) {
        System.out.println("[" + index + "] Optie:" + option.getName());
        System.out.println("Categorie: " + option.getType() + " Prijs: " + option.getPrice() + " Milieuvriendelijke kortingspercentage: " + option.getEnvironmentDiscount());

        if(option.calculateEnvironmentDiscount() != option.getPrice())
            System.out.println("Prijs incl. korting: " + option.calculateEnvironmentDiscount());

        if(option.getDescription() != null)
            System.out.println("Beschrijving: " + option.getDescription());
    }
}

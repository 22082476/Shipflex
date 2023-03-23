import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Info {

    // hier moet nog een customer en company list
    private ArrayList<Option> options;

    Info() {
        this.options = new ArrayList<>();
    }

    public void readOptionsFromFile(String filePath) {

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
                    addOption(new Option(row[0], price, row[2], environmentDiscount, new ArrayList<String>(List.of(essentialBoatTypes)), new ArrayList<String>(List.of(extraForBoatTypes)), row[6]));
                else
                    addOption(new Option(row[0], price, row[2], environmentDiscount, new ArrayList<String>(List.of(essentialBoatTypes)), new ArrayList<String>(List.of(extraForBoatTypes))));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Option> getOptions() {
        return this.options;
    }

    public void addOption(Option option) {
        this.options.add(option);
    }

    public void printOptions(String boatType) {
        for(Option option : options) {

            System.out.println("[ESSENTIAL OPTIONS]");
            for(String boat : option.getEssentialForBoatType()) {
                if(!boat.equals(boatType))
                    continue;

                printOptionInfo(option);
                System.out.println();
            }

            System.out.println("[EXTRA OPTIONS]");
            for(String boat : option.getExtraForBoatType()) {
                if(!boat.equals(boatType))
                    continue;

                printOptionInfo(option);
                System.out.println();
            }
        }
    }

    public void printOptionInfo(Option option) {
        System.out.println("Option: " + option.getName());
        System.out.println("Type: " + option.getType() + " Price: " + option.getPrice() + " Environment discount: " + option.getEnvironmentDiscount());

        if(option.getDescription() != null)
            System.out.println("Description: " + option.getDescription());
    }
}

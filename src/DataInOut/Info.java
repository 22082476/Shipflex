package DataInOut;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import Boat.Option;

public class Info {

    private static List<Option> options = new ArrayList<>();

    public static void readOptionsFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            options = br.lines()
                    .skip(1) // Skip the first line (header)
                    .map(Info::parseOption)
                    .sorted(Comparator.comparing(Option::getType))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Option parseOption(String line) {
        String[] row = line.split(",");
        String[] essentialBoatTypes = row[4].toLowerCase().split(";");
        String[] extraForBoatTypes = row[5].toLowerCase().split(";");

        double price = Double.parseDouble(row[1]);
        int environmentDiscount = Integer.parseInt(row[3]);

        return new Option(
                row[0], price, row[2], environmentDiscount,
                List.of(essentialBoatTypes), List.of(extraForBoatTypes),
                row.length > 6 ? row[6] : null
        );
    }

    public static List<Option> getOptions() {
        return options;
    }

    public static void addOption(Option option) {
        options.add(option);
    }

    public static Option getOptionFromName(String name) {
        for(Option option : options) {
            if(!option.getName().equalsIgnoreCase(name))
                continue;

            return option;
        }

        return null;
    }

    public static List<Integer> printOptionsForBoatType(String boatType) {
        Printer.getInstance().emptyLine();
        List<Integer> validOptionsIndexes = new ArrayList<>();
        List<Option> essentialOptions = new ArrayList<>();
        List<Option> extraOptions = new ArrayList<>();

        int index = 0;

        for(Option option : options) {
            if(option.getEssentialForBoatType().contains(boatType.toLowerCase())) {
                essentialOptions.add(option);
            } else if (option.getExtraForBoatType().contains(boatType.toLowerCase())) {
                extraOptions.add(option);
            }

            validOptionsIndexes.add(index);
            index++;
        }

        Printer.getInstance().printLine("ESSENTIËLE OPTIES");
        Printer.getInstance().emptyLine();
        printOptionsInList(essentialOptions);

        Printer.getInstance().printLine("EXTRA OPTIES");
        Printer.getInstance().emptyLine();
        printOptionsInList(extraOptions);

        return validOptionsIndexes;
    }

    private static void printOptionsInList(List<Option> options) {
        for(int i = 0; i < options.size(); i++) {
            printOptionInfo(options.get(i), getOptions().indexOf(options.get(i)));
            Printer.getInstance().emptyLine();
        }
    }

    public static void printOptionInfo(Option option, int index) {
        String stringIndex = (index == -1 ? "X" : String.valueOf(index));

        Printer.getInstance().printLine("[" + stringIndex + "] Optie: " + option.getName());
        Printer.getInstance().printLine("Categorie: " + option.getType() + " Prijs: " + option.getPrice() + " Milieuvriendelijke kortingspercentage: " + option.getEnvironmentDiscount());

        if(option.calculateEnvironmentDiscount() != option.getPrice())
            Printer.getInstance().printLine(String.format("Prijs incl. korting: %.2f", option.calculateEnvironmentDiscount()));

        if(option.getDescription() != null)
            Printer.getInstance().printLine("Beschrijving: " + option.getDescription());
    }
}

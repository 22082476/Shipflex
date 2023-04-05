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

    public static List<Integer> printOptionsForBoatType(String boatType) {
        System.out.println();
        List<Integer> validOptionsIndexes = new ArrayList<>();
        List<Option> validOptions = new ArrayList<>();

        int index = 0;

        for(Option option : options) {
            if(option.getEssentialForBoatType().contains(boatType.toLowerCase()) || option.getExtraForBoatType().contains(boatType.toLowerCase())) {
                validOptions.add(option);
                validOptionsIndexes.add(index);
            }

            index++;
        }

        printOptionsInList(validOptions, validOptionsIndexes);

        return validOptionsIndexes;
    }

    private static void printOptionsInList(List<Option> options, List<Integer> indexes) {
        for(int i = 0; i < options.size(); i++) { // Indexes en options zijn altijd even lang dus maakt niet uit welke size je gebruikt
            printOptionInfo(options.get(i), indexes.get(i));
            Printer.printLine("");
        }
    }


    public static void printOptionInfo(Option option, int index) {
        String stringIndex = (index == -1 ? "X" : String.valueOf(index));

        Printer.printLine("[" + stringIndex + "] Optie: " + option.getName());
        Printer.printLine("Categorie: " + option.getType() + " Prijs: " + option.getPrice() + " Milieuvriendelijke kortingspercentage: " + option.getEnvironmentDiscount());

        if(option.calculateEnvironmentDiscount() != option.getPrice())
            Printer.printLine("Prijs incl. korting: " + option.calculateEnvironmentDiscount());

        if(option.getDescription() != null)
            Printer.printLine("Beschrijving: " + option.getDescription());
    }


}

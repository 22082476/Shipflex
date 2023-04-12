package Shipflex;

import Boat.Option;
import DataInOut.Info;
import DataInOut.Printer;
import DataInOut.ScanInput;

import java.util.List;


import static Shipflex.MakeQuote.quote;

public class MakeQuoteBoat {

    private String [] commands = {"terug", "beschikbare opties", "gekozen opties", "optie toevoegen", "optie verwijderen", "boot wijzigen", "boot laten zien"};


    public void start(){
        while(true) {
            Printer.getInstance().printTextGenerateQuote(this.commands);
            int inputIndex = ScanInput.scanInt();
            Printer.getInstance().emptyLine();
            switch (inputIndex) {
                case 0:
                    return;
                case 1:
                    Info.printOptionsForBoatType(quote.getBoat().getType());
                    break;
                case 2:
                    quote.printOptions(false);
                    Printer.getInstance().printLine(String.format("Prijs van alles excl BTW: %.2f", calculateTotalOptionsPrice()));
                    break;
                case 3:
                    selectOption();
                    break;
                case 4:
                    removeOptionFromBoat();
                    break;
                case 5:
                    quote.getBoat().changeBoat();
                    break;
                case 6:
                    quote.getBoat().printBoat();
                    break;
                default:
                    Printer.getInstance().printLine("Incorrecte invoer!");
                    Printer.getInstance().printLine("probeer opniew");
            }
            Printer.getInstance().emptyLine();

        }
    }

    public void selectOption() {
        List<Integer> validIndexes = Info.printOptionsForBoatType(quote.getBoat().getType());

        String inputString = ScanInput.inputQuestion("de nummer van de optie (stop om te stoppen)");

        if(!ScanInput.ableToParse(inputString)) {
            if(inputString.equalsIgnoreCase("stop")) {
                return;
            }
            Printer.getInstance().printLine("Geen nummer ingevuld!");
            delaySelectOption();
            return;
        }

        int optionIndex = Integer.parseInt(inputString);

        if(!validIndexes.contains(optionIndex)) {
            Printer.getInstance().printLine("Verkeerde nummer ingevuld!");
            delaySelectOption();
        } else if(quote.getBoat().getOptions().contains(Info.getOptions().get(optionIndex))) {
            Printer.getInstance().printLine("Deze optie is al toegevoegd!");
            delaySelectOption();
        } else {
            quote.getBoat().addOption(Info.getOptions().get(optionIndex));
            Printer.getInstance().printLine("Je hebt optie " + Info.getOptions().get(optionIndex).getName() + " toegevoegd aan de huidige boot!");

            String answer = ScanInput.inputQuestion("ja of nee voor milieukorting");

            if(!answer.equalsIgnoreCase("ja")) {
                Printer.getInstance().printLine("Geen milieukorting toegepast voor optie " + Info.getOptions().get(optionIndex).getName());
                delaySelectOption();
            } else {
                askEnvironmentDiscountForOption(Info.getOptions().get(optionIndex));
            }
        }
    }

    public void askEnvironmentDiscountForOption(Option option) {
        String inputString = ScanInput.inputQuestion("de milieukorting percentage");

        if(!ScanInput.ableToParse(inputString)) {
            Printer.getInstance().printLine("Geen nummer ingevuld!");
            delaySelectOption();
            return;
        }

        int discount = Integer.parseInt(inputString);

        if(discount < 1 || discount > 100) {
            Printer.getInstance().printLine("Vul een getal in boven 0 en onder de 100!");
            askEnvironmentDiscountForOption(option);
            return;
        }

        option.setEnvironmentDiscount(discount);
        Printer.getInstance().printLine("Je hebt " + discount + "%% milieukorting toegevoegd aan optie " + option.getName());

        delaySelectOption();
    }

    private void delaySelectOption() {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        selectOption();
    }


    private void removeOptionFromBoat() {
        quote.printOptions(true);
        int indexInput = ScanInput.inputNumber("de nummer in van de optie die je wilt weghalen");
        Option option = Info.getOptions().get(indexInput);

        if(!quote.getBoat().getOptions().contains(option)) {
            Printer.getInstance().printLine("Die nummer zit niet in de lijst, probeer opnieuw.");
        } else {
            quote.getBoat().removeOption(option);
        }

        Printer.getInstance().printLine("Je hebt optie " + option.getName() + " weggehaald.");
    }

    private double calculateTotalOptionsPrice() {
        double totalPrice = 0;

        for(Option option : quote.getBoat().getOptions()) {
            totalPrice += option.getPrice();
        }

        return totalPrice;
    }
}

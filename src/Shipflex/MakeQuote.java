package Shipflex;

import Boat.*;
import Customer.*;
import DataInOut.*;

import java.util.List;

public class MakeQuote {
    private Boat boat;
    private Quote quote;


    public MakeQuote(String boatType, Company company){
        this.boat = getFromTypeBoat(boatType);
        this.quote = new Quote(company, this.boat);
    }


    public void start(){
        while(true) {
            printTextGenerateQuote();
            int inputIndex = ScanInput.scanInt();

            switch (inputIndex) {
                case 0:
                    return;
                case 1, 2:
                    askCustomer();
                    break;
                case 3:
                    quote.printCustomer();
                    break;
               case 4:
                    Info.printOptionsForBoatType(boat.getType());
                    break;
               case 5:
                    quote.printOptions();
                    break;
                case 6:
                    selectOption();
                    break;
                default:
                    Printer.printLine("Incorrecte invoer!");
                    Printer.printLine("probeer opniew");
            }

        }
    }

    private void printTextGenerateQuote(){
        Printer.printLine("Commands: [0] terug, [1] voeg klant toe, [2] wijzig klant, [3] laat klant zien, [4] beschikbare opties, [5] gekozen opties, [6] voeg optie toe");
        Printer.print("Voer een command in: ");
    }


    private Boat getFromTypeBoat(String boatType){
        switch (boatType){
            case "plezierjacht":
                return new PleasureYacht();
            case "rubberboot":
                return new InflatableBoat();
            case "speedboot":
                return new SpeedBoat();
            case "zeilboot":
                return new SailBoat();
            default:
                return null;
        }
}


    public void askCustomer(){
        String customerType = ScanInput.inputQuestion("soort klant");

        switch (customerType){
            case "zakelijk":
                quote.setBusinessCustomer(new BusinessCustomer(ScanInput.inputQuestion("de naam"), ScanInput.inputQuestion("de straat"), ScanInput.inputQuestion("de postcode"), ScanInput.inputQuestion("de plaats"), ScanInput.inputNumber("het huisnummer"), ScanInput.inputNumber("het korting percentage"), ScanInput.inputQuestion("de naam van de bedrijf")));
                break;
            case "overheid":
                quote.setGovermentCustomer(new GovermentCustomer(ScanInput.inputQuestion("de naam"), ScanInput.inputQuestion("de straat"), ScanInput.inputQuestion("de postcode"), ScanInput.inputQuestion("de plaats"), ScanInput.inputNumber("het huisnummer"), ScanInput.inputNumber("het korting percentage"), ScanInput.inputQuestion("de naam van de ministerie")));
                break;
            case "stichting":
                quote.setFoundationCustomer(new FoundationCustomer(ScanInput.inputQuestion("de naam"), ScanInput.inputQuestion("de straat"), ScanInput.inputQuestion("de postcode"), ScanInput.inputQuestion("de plaats"), ScanInput.inputNumber("het huisnummer"), ScanInput.inputNumber("het korting percentage"), ScanInput.inputQuestion("de naam van de stiching")));
                break;
            default:
                quote.setCustomer(new Customer(ScanInput.inputQuestion("de naam"), ScanInput.inputQuestion("de straat"), ScanInput.inputQuestion("de postcode"), ScanInput.inputQuestion("de plaats"), ScanInput.inputNumber("het huisnummer"), ScanInput.inputNumber("het korting percentage")));
                break;
        }

        askForExtraGegevens();
    }

    public void selectOption() {
        List<Integer> validIndexes = Info.printOptionsForBoatType(boat.getType());

        String inputString = ScanInput.inputQuestion("de nummer van de optie (stop om te stoppen)");

        if(!ScanInput.ableToParse(inputString)) {
            if(inputString.equalsIgnoreCase("stop")) {
                return;
            }
            Printer.printLine("Geen nummer ingevuld!");
            delaySelectOption();
            return;
        }

        int optionIndex = Integer.parseInt(inputString);

        if(!validIndexes.contains(optionIndex)) {
            Printer.printLine("Verkeerde nummer ingevuld!");
            delaySelectOption();
        } else if(quote.getBoat().getOptions().contains(Info.getOptions().get(optionIndex))) {
            Printer.printLine("Deze optie is al toegevoegd!");
            delaySelectOption();
        } else {
            quote.getBoat().addOption(Info.getOptions().get(optionIndex));
            Printer.printLine("Je hebt optie " + Info.getOptions().get(optionIndex).getName() + " toegevoegd aan de huidige boot!");

            String answer = ScanInput.inputQuestion("ja of nee voor milieukorting");

            if(!answer.equalsIgnoreCase("ja")) {
                Printer.printLine("Geen milieukorting toegepast voor optie " + Info.getOptions().get(optionIndex).getName());
                delaySelectOption();
            } else {
                askEnvironmentDiscountForOption(Info.getOptions().get(optionIndex));
            }
        }
    }

    public void askEnvironmentDiscountForOption(Option option) {
        String inputString = ScanInput.inputQuestion("de milieukorting percentage");

        if(!ScanInput.ableToParse(inputString)) {
            Printer.printLine("Geen nummer ingevuld!");
            delaySelectOption();
            return;
        }

        int discount = Integer.parseInt(inputString);

        if(discount < 1 || discount > 100) {
            Printer.printLine("Vul een getal in boven 0 en onder de 100!");
            askEnvironmentDiscountForOption(option);
            return;
        }

        option.setEnvironmentDiscount(discount);
        Printer.printLine("Je hebt " + discount + "% milieukorting toegevoegd aan optie " + option.getName());

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

    private void askForExtraGegevens() {
        Printer.printLine("Wilt u nog extra gegevens toevoegen voor deze klant?");
        String input = ScanInput.inputQuestion("ja of nee in voor extra gegevens");
        String[] gegevens;

        if(input.equalsIgnoreCase("ja")) {
            gegevens = getExtraGegevensFromInput();
            if(quote.getCustomer() != null)
                quote.getCustomer().addExtraGegeven(gegevens[0], gegevens[1]);
            else if (quote.getBusinessCustomer() != null)
                quote.getBusinessCustomer().addExtraGegeven(gegevens[0], gegevens[1]);
            else if (quote.getFoundationCustomer() != null)
                quote.getFoundationCustomer().addExtraGegeven(gegevens[0], gegevens[1]);
            else if (quote.getGovermentCustomer() != null)
                quote.getGovermentCustomer().addExtraGegeven(gegevens[0], gegevens[1]);

            askForExtraGegevens();
        }
    }

    private String[] getExtraGegevensFromInput() {
        String key = ScanInput.inputQuestion("de type gegeven (bijv. 'email')");
        String value = ScanInput.inputQuestion("de gegeven (bijv. 'jan@gmail.com)'");

        String[] ret = {key, value};

        return ret;
    }
}

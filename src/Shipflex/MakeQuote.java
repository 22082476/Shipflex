package Shipflex;

import Boat.*;
import Customer.*;
import DataInOut.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MakeQuote {

    protected Quote quote;


    public MakeQuote(String boatType, Company company){
        this.quote = new Quote(company, getFromTypeBoat(boatType));
    }


    public void start(){
        askBasicInfo();

        while(true) {
            printTextGenerateQuote();
            int inputIndex = ScanInput.scanInt();

            switch (inputIndex) {
                case 0:
                    return;
                case 1, 2:
                    Printer.emptyLine();
                    askCustomer();
                    break;
                case 3:
                    quote.printCustomer();
                    break;
               case 4:
                   Printer.emptyLine();
                    Info.printOptionsForBoatType(quote.getBoat().getType());
                    break;
               case 5:
                    quote.printOptions(false);
                    Printer.emptyLine();
                    break;
                case 6:
                    Printer.emptyLine();
                    selectOption();
                    break;
                case 7:
                    quote.printQuote();
                    break;
                case 8:
                    askBasicInfo();
                    break;
                case 9:
                    Printer.emptyLine();
                    quote.printBasicInformation();
                    break;
                case 10:
                    removeOptionFromBoat();
                    break;
                case 11:
                    askWorkHours();
                    break;
                case 10:
                    quote.setWorkhours(ScanInput.inputNumber("de arbeidsuren"));
                    break;
                default:
                    Printer.emptyLine();
                    Printer.printLine("Incorrecte invoer!");
                    Printer.printLine("probeer opniew");
            }

        }
    }

    public void askBasicInfo(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        quote.setDate(sdf.format(date));
        quote.setQuoteDate(ScanInput.inputQuestion("de geldigheids datum voor de offerte(dd-mm-yyyy)"));
        quote.setAbout(ScanInput.inputQuestion("de betreft"));
        Printer.emptyLine();
    }

    private void printTextGenerateQuote(){
        String [] input = {"terug", "voeg klant toe", "wijzig klant", "laat klant zien", "beschikbare opties", "gekozen opties", "voeg optie toe", "offerte printen", "basis gegevens wijzigen", "basisgegevens laten zien", "optie weghalen", "Voeg arbeidsuren toe"};

        Printer.print("Commands: ");
        for(int i = 0; i < input.length; i++){
            if(i == input.length-1){
                Printer.printLine("[" +i+ "] " + input[i]);
            }else {
                Printer.print("[" +i+ "] " + input[i] + ", ");
            }

            if (i == input.length / 2)
                Printer.emptyLine();
        }
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




    public void selectOption() {
        List<Integer> validIndexes = Info.printOptionsForBoatType(quote.getBoat().getType());

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
        Printer.printLine("Je hebt " + discount + "%% milieukorting toegevoegd aan optie " + option.getName());

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
            Printer.printLine("Die nummer zit niet in de lijst, probeer opnieuw.");
        } else {
            quote.getBoat().removeOption(option);
        }

        Printer.printLine("Je hebt optie " + option.getName() + " weggehaald.");
    }

    public void askWorkHours(){
        int hour = ScanInput.inputNumber("de arbeidsuren");
        double workHours = hour * ScanInput.inputNumberD("voer uurtarief");
        quote.setWorkhours(workHours);


    }
}

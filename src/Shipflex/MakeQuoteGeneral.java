package Shipflex;

import DataInOut.Printer;
import DataInOut.ScanInput;

import java.text.SimpleDateFormat;
import java.util.Date;

import static Shipflex.MakeQuote.quote;

public class MakeQuoteGeneral {

    private String [] commands = {"terug", "basis gegevens wijzigen", "basisgegevens laten zien", "Voeg arbeidsuren toe"};


    public void start(){
        while(true) {
            Printer.getInstance().printTextGenerateQuote(this.commands);
            int inputIndex = ScanInput.inputNumber("command");
            Printer.getInstance().emptyLine();
            switch (inputIndex) {
                case 0:
                    return;
                case 1:
                    askBasicInfo();
                    break;
                case 2:
                    quote.printBasicInformation();
                    break;

                case 3:
                    askWorkHours();
                    break;
                default:
                    Printer.getInstance().printLine("Incorrecte invoer!");
                    Printer.getInstance().printLine("probeer opniew");
            }
            Printer.getInstance().emptyLine();
        }
    }


    public void askBasicInfo(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        quote.setDate(sdf.format(date));
        quote.setQuoteDate(ScanInput.inputQuestion("de geldigheids datum voor de offerte(dd-mm-yyyy)"));
        quote.setAbout(ScanInput.inputQuestion("de betreft"));
        Printer.getInstance().emptyLine();
    }

    public void askWorkHours(){
        int hour = ScanInput.inputNumber("de arbeidsuren");
        double workHours = hour * ScanInput.inputNumberD("voer uurtarief");
        quote.setWorkHoursCost(workHours);
    }
}

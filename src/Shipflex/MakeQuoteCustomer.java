package Shipflex;

import Customer.BusinessCustomer;
import Customer.Customer;
import Customer.FoundationCustomer;
import Customer.GovermentCustomer;
import DataInOut.Printer;
import DataInOut.ScanInput;


import static Shipflex.MakeQuote.quote;

public class MakeQuoteCustomer {

    private String [] commands = {"terug", "klant laten zien", "klant toevoegen", "klant wijzigen"};




    public void start(){
        while(true) {
            Printer.getInstance().printTextGenerateQuote(this.commands);
            int inputIndex = ScanInput.inputNumber("command");
            Printer.getInstance().emptyLine();
            switch (inputIndex) {
                case 0:
                    return;
                case 1:
                    quote.printCustomer();
                    break;
                case 2, 3:
                    askCustomer();
                    break;
                default:
                    Printer.getInstance().printLine("Incorrecte invoer!");
                    Printer.getInstance().printLine("probeer opniew");
            }
            Printer.getInstance().emptyLine();

        }
    }



    public void askCustomer(){
        String customerType = ScanInput.inputQuestion("soort klant (zakelijk, overheid, stichting, anders)");

        switch (customerType){
            case "zakelijk":
                quote.setBusinessCustomer(new BusinessCustomer(ScanInput.inputQuestion("de naam"), ScanInput.inputQuestion("de straat"), ScanInput.inputNumber("het huisnummer"), ScanInput.inputQuestion("de postcode(0000 AA)"), ScanInput.inputQuestion("de plaats"), ScanInput.inputQuestion("het land"), ScanInput.inputNumber("het korting percentage"), ScanInput.inputQuestion("de naam van de bedrijf")));
                break;
            case "overheid":
               quote.setGovermentCustomer(new GovermentCustomer(ScanInput.inputQuestion("de naam"), ScanInput.inputQuestion("de straat"), ScanInput.inputNumber("het huisnummer"), ScanInput.inputQuestion("de postcode(0000 AA)"), ScanInput.inputQuestion("de plaats"), ScanInput.inputQuestion("het land"), ScanInput.inputNumber("het korting percentage"), ScanInput.inputQuestion("de naam van de ministerie")));
                break;
            case "stichting":
                quote.setFoundationCustomer(new FoundationCustomer(ScanInput.inputQuestion("de naam"), ScanInput.inputQuestion("de straat"), ScanInput.inputNumber("het huisnummer"), ScanInput.inputQuestion("de postcode(0000 AA)"), ScanInput.inputQuestion("de plaats"), ScanInput.inputQuestion("het land"), ScanInput.inputNumber("het korting percentage"), ScanInput.inputQuestion("de naam van de stiching")));
                break;
            default:
                quote.setCustomer(new Customer(ScanInput.inputQuestion("de naam"), ScanInput.inputQuestion("de straat"), ScanInput.inputNumber("het huisnummer"), ScanInput.inputQuestion("de postcode(0000 AA)"), ScanInput.inputQuestion("de plaats"), ScanInput.inputQuestion("het land"), ScanInput.inputNumber("het korting percentage")));
                break;
        }

        askForExtraGegevens();
    }

    private void askForExtraGegevens() {
        Printer.getInstance().printLine("Wilt u nog extra gegevens toevoegen voor deze klant?");
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

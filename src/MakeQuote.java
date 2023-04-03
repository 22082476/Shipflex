import java.util.ArrayList;

public class MakeQuote {
//    private String boatType;
    private Boat boat;
    private Quote quote;
    private Info dataInput = new Info();

    public MakeQuote(String boatType, Company company){
        this.boat = getFromTypeBoat(boatType);
        this.quote = new Quote(company, this.boat);
    }


    public void start(){
        while(true) {
            printTextGenerateQuote();
            int inputIndex = ScanInput.scanInt();

            switch (inputIndex) {
                case 1, 2:
                    askCustomer();
                    break;
                case 5:
                    quote.printOptions();
                    break;
                case 3:
                    quote.printCustomer();
                    break;
                case 4:
                    Info.printOptionsForBoatType(boat.getType());
                    break;
                case 6:
                    selectOption();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Incorrecte invoer!");
                    System.out.println("probeer opniew");
            }

        }
    }

    private void printTextGenerateQuote(){
        System.out.printf("Commands: [0]terug, [1]voeg klant toe, [2]wijzig klant, [3]laat klant zien, [4]beschikbare opties, [5]gekozen opties, [6]voeg optie toe%n");
        System.out.print("Voer een command in: ");

    }

    private Boat getFromTypeBoat(String boatType){
        if(boatType.equals("plezier jacht")){
            return new PleasureYacht();
        }else if(boatType.equals("rubberboot")){
         return new InflatableBoat();
        }else if(boatType.equals("speedboot")){
            return new SpeedBoat();
        }else if(boatType.equals("zeilboot")){
            return new SailBoat();
        }else {
            return null;
        }
}


    public void askCustomer(){
        System.out.print("Voer soort klant in: ");
        String typcustomer = ScanInput.scanInL();
        if(typcustomer.equals("zakelijk")){
            quote.setBusinessCustomer(new BusinessCustomer(inputQuestion("de naam"), inputQuestion("de straat"), inputQuestion("de postcode"), inputQuestion("de plaats"), Integer.parseInt(inputQuestion("het huisnummer")), Integer.parseInt(inputQuestion("het korting percentage")), inputQuestion("de naam van de bedrijf")));
        }else if(typcustomer.equals("overheid")){
            quote.setGovermentCustomer(new GovermentCustomer(inputQuestion("de naam"), inputQuestion("de straat"), inputQuestion("de postcode"), inputQuestion("de plaats"), Integer.parseInt(inputQuestion("het huisnummer")), Integer.parseInt(inputQuestion("het korting percentage")), inputQuestion("de naam van de ministerie")));
        }else if(typcustomer.equals("stichting")){
            quote.setFoundationCustomer(new FoundationCustomer(inputQuestion("de naam"), inputQuestion("de straat"), inputQuestion("de postcode"), inputQuestion("de plaats"), Integer.parseInt(inputQuestion("het huisnummer")), Integer.parseInt(inputQuestion("het korting percentage")), inputQuestion("de naam van de stiching")));
        }else {
            quote.setCustomer(new Customer(inputQuestion("de naam"), inputQuestion("de straat"), inputQuestion("de postcode"), inputQuestion("de plaats"), Integer.parseInt(inputQuestion("het huisnummer")), Integer.parseInt(inputQuestion("het korting percentage"))));
        }
    }

    public void selectOption() {
        ArrayList<Integer> validIndexes = Info.printOptionsForBoatType(boat.getType());

        String inputString = inputQuestion("de nummer van de optie (stop om te stoppen)");

        if(!ableToParse(inputString)) {
            if(inputString.equalsIgnoreCase("stop")) {
                printTextGenerateQuote();
                return;
            }
            System.out.println("Geen nummer ingevuld!");
            delaySelectOption();
            return;
        }

        int optionIndex = Integer.parseInt(inputString);

        if(!validIndexes.contains(optionIndex)) {
            System.out.println("Verkeerde nummer ingevuld!");
            delaySelectOption();
        } else if(quote.getBoat().getOptions().contains(Info.getOptions().get(optionIndex))) {
            System.out.println("Deze optie is al toegevoegd!");
            delaySelectOption();
        } else {
            quote.getBoat().addOption(Info.getOptions().get(optionIndex));
            System.out.println("Je hebt optie " + Info.getOptions().get(optionIndex).getName() + " toegevoegd aan de huidige boot!");

            String answer = inputQuestion("ja of nee voor milieukorting");

            if(!answer.equalsIgnoreCase("ja")) {
                System.out.println("Geen milieukorting toegepast voor optie " + Info.getOptions().get(optionIndex).getName());
                delaySelectOption();
            } else {
                askEnvironmentDiscountForOption(Info.getOptions().get(optionIndex));
            }
        }
    }

    public void askEnvironmentDiscountForOption(Option option) {
        String inputString = inputQuestion("de milieukorting percentage");

        if(!ableToParse(inputString)) {
            System.out.println("Geen nummer ingevuld!");
            delaySelectOption();
            return;
        }

        int discount = Integer.parseInt(inputString);

        if(discount < 1 || discount > 100) {
            System.out.println("Vul een getal in boven 0 en onder de 100!");
            askEnvironmentDiscountForOption(option);
            return;
        }

        option.setEnvironmentDiscount(discount);
        System.out.println("Je hebt " + discount + "% milieukorting toegevoegd aan optie " + option.getName());

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

    private String inputQuestion(String soort){
        System.out.printf("Voer %s in: ", soort);
        return ScanInput.scanInH();
    }

    private boolean ableToParse(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

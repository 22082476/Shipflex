

public class MakeQuote {
//    private String boatType;
    private Boat boat;
    private Quote quote;
    private Info dataInput = new Info();

    public MakeQuote(String boatType, Company company){
        this.quote = new Quote(company);
        this.boat = getFromTypeBoat(boatType);

    }


    public void start(){
        while(true) {
            printTextGenerateQuote();
            String inputstr = ScanInput.scanInL();

            switch (inputstr) {
                case "voeg klant toe", "wijzig klant":
                    askCustomer();
                    break;
                case "gekozen opties":
//                   quote.printOptions();
                    break;
                case "laat klant zien":
                    quote.printCustomer();
                    break;
                case "beschikbare opties":
                    Info.printOptionsForBoatType(boat.getType());
                    break;
                case "voeg optie toe":
                    printTextGenerateQuote();
                    break;
                case "terug":
                    return;
                default:
                    System.out.println("Incorrecte invoer!");
                    System.out.println("probeer opniew");
            }

        }
    }

    private void printTextGenerateQuote(){
        System.out.printf("Commands: \'voeg klant toe\', \'wijzig klant\', \'laat klant zien\', \'beschikbare opties\', \'gekozen opties\', \'terug\' %n");
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
            quote.setBusinessCustomer(new BusinessCustomer(inputVar("de naam"), inputVar("de straat"), inputVar("de postcode"), inputVar("de plaats"), Integer.parseInt(inputVar("het huisnummer")), Integer.parseInt(inputVar("het korting percentage")), inputVar("de naam van de bedrijf")));
        }else if(typcustomer.equals("overheid")){
            quote.setGovermentCustomer(new GovermentCustomer(inputVar("de naam"), inputVar("de straat"), inputVar("de postcode"), inputVar("de plaats"), Integer.parseInt(inputVar("het huisnummer")), Integer.parseInt(inputVar("het korting percentage")), inputVar("de naam van de ministerie")));
        }else if(typcustomer.equals("stichting")){
            quote.setFoundationCustomer(new FoundationCustomer(inputVar("de naam"), inputVar("de straat"), inputVar("de postcode"), inputVar("de plaats"), Integer.parseInt(inputVar("het huisnummer")), Integer.parseInt(inputVar("het korting percentage")), inputVar("de naam van de stiching")));
        }else {
            quote.setCustomer(new Customer(inputVar("de naam"), inputVar("de straat"), inputVar("de postcode"), inputVar("de plaats"), Integer.parseInt(inputVar("het huisnummer")), Integer.parseInt(inputVar("het korting percentage"))));
        }
    }

    private String inputVar(String soort){
        System.out.printf("Voer %s in: ", soort);
        return ScanInput.scanInH();
    }
}

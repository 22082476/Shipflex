

public class MakeQuote {
    private String boatType;
    private Boat boat;
    private Quote quote;
    private Info dataInput = new Info();

    public MakeQuote(String boatType, Company company){
        this.boatType = boatType;
        this.quote = new Quote(company);
        this.boat = getFromTypeBoat(this.boatType);

    }


    public void start(){
        while(true) {
            printTextGenerateQuote();
           String inputstr = ScanInput.scanInL();

            if (inputstr.equals("voeg klant toe")) {
                askCustomer();

            }
            else if (inputstr.equals("wijzig klant")) {
                askCustomer();
            }
            else if (inputstr.equals("gekozen opties")) {
//                quote.printOptions();
            }
            else if (inputstr.equals("beschikbare opties")) {
                Info.printOptionsForBoatType(this.boatType);
            }
            else if(inputstr.equals("voeg optie mee")) {
                printTextGenerateQuote();
            }
            else if(inputstr.equals("laat klant zien")){
                quote.printCustomer();
            }
            else if (inputstr.equals("terug")) {
                break;
            }
            else {
                System.out.println("Incorrecte invoer!");
                System.out.println( "probeer opniew");
        }
        }
    }

    private void printTextGenerateQuote(){
        System.out.printf("Commands: \'voeg klant toe\', \'wijzig klant\', \'laat klant zien\', \'beschikbare opties\', \'gekozen opties\', \'terug\' %n");
        System.out.print("Voer een command in: ");

    }

    private Boat getFromTypeBoat(String boatType){
        if(boatType.equals("plezier jacht")){
            return null;//new PleasureYacht();
        }else if(boatType.equals("boot")){
         return new Boat("test", "boot", 3000.00);
        }else {
            return null;
        }

    }

    public void askCustomer(){
        System.out.print("Voer soort klant in: ");
        String typcustomer = ScanInput.scanInL();
        if(typcustomer.equals("zakelijk")){
            quote.setBusinessCustomer(new BusinessCustomer(inputName(), inputStreet(), inputPostcode(), inputCity(),inputIntHouseNumber(), 10, inputName("bedrijf")));
        }else if(typcustomer.equals("overheid")){
            quote.setGovermentCustomer(new GovermentCustomer(inputName(), inputStreet(), inputPostcode(), inputCity(),inputIntHouseNumber(),15,inputName("ministerie")));
        }else {
            quote.setCustomer(new Customer(inputName(), inputStreet(), inputPostcode(), inputCity(),inputIntHouseNumber(), inputIntDiscount()));
        }
    }

    private String inputName(String soort){
        System.out.printf("Voer de naam van het %s in: ", soort);
        return ScanInput.scanInH();
    }
    private int inputIntHouseNumber(){
        System.out.print("Voer de huisnummer in: ");
        return ScanInput.scanInInt();
    }

    private int inputIntDiscount(){
        System.out.print("Voer de korting percentage in: ");
        return ScanInput.scanInInt();
    }

    private String inputName(){
        System.out.print("Voer de naam in: ");
        return ScanInput.scanInH();
    }

    private String inputCity(){
        System.out.print("Voer de plaats in: ");
        return ScanInput.scanInH();
    }

    private String inputStreet(){
        System.out.print("Voer de straat in: ");
        return ScanInput.scanInH();
    }

    private String inputPostcode(){
        System.out.print("Voer de postcode in: ");
        return ScanInput.scanInH();
    }






}

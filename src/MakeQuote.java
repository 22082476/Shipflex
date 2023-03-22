public class MakeQuote {
    private String boatType;
    private Boat boat;
    private Quote quote;
    private Info dataInput = new Info();

    public MakeQuote(String boatType){
        this.boatType = boatType;
        this.quote = new Quote();
        this.boat = getFromTypeBoat(this.boatType);

    }

    public Boat getFromTypeBoat(String boatType){
        if(boatType.equals("plezier jacht")){
            return new PleasureYacht();
        }else{
         return null;
        }

    }

    public void askCustomer(){
        System.out.println("Voer soort klant in:");
        String typcustomer = ScanInput.scanInL();
        if(typcustomer.equals("zakelijk")){
            quote.setCustomer(new BusinessCustomer(inputName(), inputStreet(), inputPostcode(), inputCity(),inputHouseNumeber(), inputDiscount(), companyName()));
        }else if(typcustomer.equals("overheid")){
            quote.setCustomer(new GovermentCustomer(inputName(), inputStreet(), inputPostcode(), inputCity(),inputHouseNumeber(),));
        }else {
            quote.setCustomer(new Customer(inputName(), inputStreet(), inputPostcode(), inputCity(),inputHouseNumeber(), inputDiscount()));
        }
    }

    public String companyName(){
        System.out.print("Voer de naam van het bedrijf in: ");
        return ScanInput.scanInH();
    }

    public String inputName(){
        System.out.print("Voer de naam in: ");
        return ScanInput.scanInH();
    }

    public String inputCity(){
        System.out.print("Voer de plaats in: ");
        return ScanInput.scanInH();
    }

    public String inputStreet(){
        System.out.print("Voer de straat in: ");
        return ScanInput.scanInH();
    }

    public String inputPostcode(){
        System.out.print("Voer de postcode in: ");
        return ScanInput.scanInH();
    }

    public int inputHouseNumeber(){
        System.out.print("Voer de huisnummer in: ");
        return ScanInput.scanInInt();
    }

    public int inputDiscount(){
        System.out.print("Voer de korting percentage in: ");
        return ScanInput.scanInInt();
    }


}

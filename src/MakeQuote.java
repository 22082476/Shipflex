import java.lang.reflect.Array;

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
            quote.setBusinessCustomer(new BusinessCustomer(inputName(), inputStreet(), inputPostcode(), inputCity(), inputIntDiscount(), inputName("bedrijf")));
        }else if(typcustomer.equals("overheid")){
            quote.setGovermentCustomer(new GovermentCustomer(inputName(), inputStreet(), inputPostcode(), inputCity(),inputIntHouseNumber(),inputIntDiscount(),inputName("ministerie")));
        }else {
            quote.setCustomer(new Customer(inputName(), inputStreet(), inputPostcode(), inputCity(),inputIntHouseNumber(), inputIntDiscount()));
        }
    }

    public String inputName(String soort){
        System.out.printf("Voer de naam van het %s in: ", soort);
        return ScanInput.scanInH();
    }
    public int inputIntHouseNumber(){
        System.out.print("Voer de huisnummer in: ");
        return ScanInput.scanInInt();
    }

    public int inputIntDiscount(){
        System.out.print("Voer de korting percentage in: ");
        return ScanInput.scanInInt();
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






}

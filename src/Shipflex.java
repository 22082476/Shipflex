public class Shipflex {

    private static ScanInput in = new ScanInput();

    private static Company company = new Company("Scheeps werf den haag", "boatstraat", "2000EA", "Den haag", 14);



    public static void main(String[] args) {
        welcomeText();


        while (true) {
            startText();
            String inputstr = in.scanInL();

            if (inputstr.equals("stop")) {
//                stop progamma
                break;
            } else if (inputstr.equals("maak offerte")) {
//                start offerte maken
                startMakeQuote();
        } else if (inputstr.equals("onderhoud")) {
//               start onderhoud
                startMaintenance();
        }else {
            System.out.println("Incorrecte invoer!");
            startText();
        }
        }

    }

    public static void welcomeText(){
        //standaard welcome tekst
        System.out.printf("Welcome by shipflex%n");
    }

    public static void startText(){
        System.out.println("Commands: \'Maak offerte\', \'onderhoud\', \'stop\'");
        System.out.print("Voer een command in: ");



    }

    public static void startMakeQuote(){
        System.out.print("Voer het boot type in: ");
        MakeQuote makeQuote = new MakeQuote(ScanInput.scanInL(), company);
        makeQuote.start();
    }

    public static void startMaintenance(){
//        Maintenance maintenance = new Maintenance();
    }
}

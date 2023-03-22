public class Shipflex {

    private static ScanInput in = new ScanInput();

    public static void main(String[] args) {
        welcomeText();
        String inputstr = null;
        while (true) {
        inputstr = in.scanInL();

            if (inputstr.equals("stop")) {
//                stop progamma
                break;
            } else if (inputstr.equals("Maak offerte")) {
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
        MakeQuote makeQuote = new MakeQuote();
    }

    public static void startMaintenance(){
//        Maintenance maintenance = new Maintenance();
    }
}

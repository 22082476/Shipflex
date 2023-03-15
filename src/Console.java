import java.util.Scanner;

public class Console {
    private static Scanner in = new Scanner(System.in);

    public static void welcome(){
        //standaard welcome tekst
        System.out.printf("Welcome by shipflex%n");
        commandsStart();
    }

    public static void commandsStart(){
        System.out.println("Commands: \'start\', \'onderhoud\', \'stop\'");
        printInputText();
    }
    public static void printInputText(){
        System.out.printf("tik een command in:%n");
    }
    public static void commandsOnderhoud(){
        System.out.printf("Commands: \'optieLijst\', \'offerteMaken\', \'optieToevoegen\', \'OptieVerwijderen\',\'back\', \'stop\'%n");
        printInputText();
    }



    public static String readIn(){
        return in.nextLine();
    }

    public static boolean terminate(String input){
        if(input.toLowerCase().equals("stop")){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args){
    welcome();
    String input = null;
    while(true){
    input = readIn();
    if(terminate(input)){
        break;
    }else {
        if(getBooStart(input)){
            //start offerte
            while(true){
                input = readIn();
            }
        } else if (getBooOnderhoud(input)) {
            commandsOnderhoud();
            while(true){
            input = readIn();
            }
        }


    }
    }
    }

    public static void checkInputCommand(String input) {
        if (getBooOptieLijst(input)){

        }else if (getBooOptieToevoegen(input)){

        }else if (getBooOptieVerwijderen(input)){

        }else if (getBooOfferteMaken(input)){

        }else {
            System.out.println("incorrecte invoer!");
        }


    }

    public static boolean getBooOnderhoud(String input){
        return input.toLowerCase().equals("onderhoud");
    }

    public static boolean getBooStart(String input){
        return input.toLowerCase().equals("start");
    }

    public static boolean getBooOptieLijst(String input){
        return input.toLowerCase().equals("optielijst");
    }

    public static boolean getBooOptieToevoegen(String input){
        return input.toLowerCase().equals("optietoevoegen");
    }

    public static boolean getBooOptieVerwijderen(String input){
        return input.toLowerCase().equals("optieverwijderen");
    }

    public static boolean getBooOfferteMaken(String input){
        return input.toLowerCase().equals("offertemaken");
    }



}


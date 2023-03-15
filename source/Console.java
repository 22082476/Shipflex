import java.util.Scanner;

public class Console {
    private static Scanner in = new Scanner(System.in);

    public static void welcome(){
        //standaard welcome tekst
        System.out.printf("Welcome by shipflex%n");
        commandsText();
    }

    public static void commandsText(){
        System.out.printf("Commands: \'optieLijst\', \'offerteMaken\', \'optieToevoegen\', \'OptieVerwijderen\', \'stop\'%n");
        System.out.println();
        System.out.printf("tik een command in:%n");
    }

    public static String readIn(){
        return in.nextLine();
    }

    public static boolean terminate(String in){
        if(in.equals("Stop")|| in.equals("stop")){
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
        checkInputCommand(input);
        commandsText();

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

    public static boolean getBooOptieLijst(String input){
        return input.equals("optieLijst") || input.equals("optielijst");
    }

    public static boolean getBooOptieToevoegen(String input){
        return in.equals("optieToevoegen") || in.equals("optietoevoegen");
    }

    public static boolean getBooOptieVerwijderen(String input){
        return input.equals("optieVerwijderen") || input.equals("optieverwijderen");
    }

    public static boolean getBooOfferteMaken(String input){
        return input.equals("offerteMaken") || input.equals("offertemaken");
    }



}


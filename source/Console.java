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
    String in = null;
    while(true){
    in = readIn();
    if(terminate(in)){
        break;
    }else {
        checkInputCommand(in);
        commandsText();

    }
    }
    }

    public static void checkInputCommand(String in) {
        if (getBooOptieLijst(in)){

        }else if (getBooOptieToevoegen(in)){

        }else if (getBooOptieVerwijderen(in)){

        }else if (getBooOfferteMaken(in)){

        }else {
            System.out.println("incorrecte invoer!");
        }


    }

    public static boolean getBooOptieLijst(String in){
        return in.equals("optieLijst") || in.equals("optielijst");
    }

    public static boolean getBooOptieToevoegen(String in){
        return in.equals("optieToevoegen") || in.equals("optietoevoegen");
    }

    public static boolean getBooOptieVerwijderen(String in){
        return in.equals("optieVerwijderen") || in.equals("optieverwijderen");
    }

    public static boolean getBooOfferteMaken(String in){
        return in.equals("offerteMaken") || in.equals("offertemaken");
    }



}


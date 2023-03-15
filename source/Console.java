import java.util.Scanner;

public class Console {
    private Scanner in = new Scanner(System.in);

    public static void welcome(){
        //standaard welcome tekst
        System.out.printf("Welcome by shipflex%n");
        commandsText();
    }

    public static void commandsText(){
        System.out.printf("Commands: \'optieLijst\', \'offerteMaken\', \'optieToevoegen\', \'OptieVerwijderen\'%n");
        System.out.println();
        System.out.printf("tik een command in:%n");
    }

    public static void main(String[] args){
    welcome();
    }


}


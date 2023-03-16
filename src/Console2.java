import java.util.Scanner;

public class Console2 {
    private static Scanner in = new Scanner(System.in);

    public static void printInputText(){
        System.out.printf("tik een command in:%n");
    }

    public static void welcome(){
        //standaard welcome tekst
        System.out.printf("Welcome by shipflex%n");
        commandsStart();
    }

    public static void commandsStart(){
        System.out.println("Commands: \'start\', \'onderhoud\', \'stop\'");
        printInputText();
    }
}

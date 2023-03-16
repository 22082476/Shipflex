import java.util.Scanner;

public class Console2 {
    private Scanner in = new Scanner(System.in);

    public void printInputText(){
        System.out.printf("tik een command in:%n");
    }

    public void welcome(){
        //standaard welcome tekst
        System.out.printf("Welcome by shipflex%n");
        commandsStart();
    }

    public void commandsStart(){
        System.out.println("Commands: \'start\', \'onderhoud\', \'stop\'");
        printInputText();
    }
    public void startQuoteBuilder(){
        String input = null;
        welcome();
        commandsStart();
        while (true){
            input = in.nextLine();
            if(input.toLowerCase().equals("stop")){
//                stop
                break;
            } else if (input.toLowerCase().equals("start")) {
//                start

            } else if (input.toLowerCase().equals("onderhoud")) {
//                onderhoud

            }
        }
    }

}


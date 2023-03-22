import java.util.Scanner;

public class Console {

    public void printInputText(){
        System.out.printf("tik een command in:%n");
    }

    public void welcomeText(){
        //standaard welcome tekst
        System.out.printf("Welcome by shipflex%n");
        startText();
    }

    public void startText(){
        System.out.println("Commands: \'start\', \'onderhoud\', \'stop\'");
        printInputText();
    }
    public void startQuoteBuilder(){
        String input = null;
        welcomeText();
        startText();

        while (true){
            input = ScanInput.scanIn();

            } else if (input.equals("start")) {
//                start

            } else if (input.equals("onderhoud")) {
//                onderhoud

            }else {
                System.out.println("Incorrecte invoer!");
                startText();
            }
        }
    }

}


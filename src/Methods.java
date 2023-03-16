import java.util.Scanner;

public class Methods {

    private String input = null;

    private void printTextMaintenance(){
        System.out.printf("Commands: \'optieLijst\', \'offerteMaken\', \'optieToevoegen\', \'OptieVerwijderen\',\'back\', \'stop\'%n");
    }

    public void maintenance(){
        printTextMaintenance();
       while(true){
          input = ScanInput.scanIn();

       }
    }

    private void printTextGenerateQuote(){
        System.out.printf("Commands: \'example\', \'example\', \'back\'%n");
    }


    public void generateQuote(){
        printTextGenerateQuote();
        while(true){
        input = ScanInput.scanIn();
        }
    }
}

package DataInOut;

public class Printer implements Print{
    private static Printer instance = null;
    public static Printer getInstance(){
        if(instance == null){
            instance = new Printer();
        }
        return instance;
    }



public void print(String text){
    System.out.print(text);
}

public void printLine(String text){
    print(String.format(text+"%n"));
}

public void emptyLine(){
    printLine("");
}

public void printSpaces(int number){
    printCharacters(number, ' ');
}

public void printCharacters(int number, char character){
    for(int i = 1; i <= number; i++){
        print("" + character);
    }
}

    public void printTextGenerateQuote(String [] input){
        printLine("Commands: ");
        for(int i = 0; i < input.length; i++){
            if(i == input.length-1){
                printLine("[" +i+ "] " + input[i]);
            }else {
                print("[" +i+ "] " + input[i] + ", ");
            }

            if (i == input.length / 2 && input.length >= 4)
                emptyLine();
        }
        print("Voer een command in: ");
    }


    
}

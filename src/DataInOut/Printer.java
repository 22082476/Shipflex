package DataInOut;

public class Printer implements Print{

public static void print(String text){
    System.out.print(text);
}

public static void printLine(String text){
    print(String.format(text+"%n"));
}

public static void emptyLine(){
    printLine("");
}

public static void printSpaces(int number){
    printCharacters(number, ' ');
}

public static void printCharacters(int number, char character){
    for(int i = 1; i <= number; i++){
        print("" + character);
    }
}

    public static void printTextGenerateQuote(String [] input){
        Printer.printLine("Commands: ");
        for(int i = 0; i < input.length; i++){
            if(i == input.length-1){
                Printer.printLine("[" +i+ "] " + input[i]);
            }else {
                Printer.print("[" +i+ "] " + input[i] + ", ");
            }

            if (i == input.length / 2 && input.length >= 4)
                Printer.emptyLine();
        }
        Printer.print("Voer een command in: ");
    }


    
}

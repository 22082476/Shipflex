package DataInOut;

public class Printer {

public static void print(String text){
    System.out.print(text);
}

public static void printLine(String text){
    print(String.format(text+"%n"));
}

public static void empytLine(){
    printLine("");
}

public static void printSpaces(int number){
    for(int i = 1; i <= number; i++){
        print(" ");
    }
}


    
}

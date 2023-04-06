package DataInOut;

public class Printer implements Print {

public void print(String text){
    System.out.print(text);
}

public void printLine(String text){
    print(String.format(text+"%n"));
}

public void empytLine(){
    printLine("");
}

public void printSpaces(int number){
    for(int i = 1; i <= number; i++){
        print(" ");
    }
}


    
}

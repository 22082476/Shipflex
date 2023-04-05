public class Printer {

public void print(String text){
    System.out.print(text);
}

public void printLine(String text){
    print(String.format(text+"%n"));
}

public void empytLine(){
    printLine("");
}


    
}

package DataInOut;

import java.util.Scanner;

public class ScanInput {
    private static Scanner in = new Scanner(System.in);

    public static String scanInL(){
        return in.nextLine().toLowerCase();
    }

    public static String scanInH(){
        return in.nextLine();
    }

    public static int scanInt(){
        int integer = in.nextInt();
        in.nextLine();
        return integer;
    }
    public static String inputQuestion(String soort){
        Printer.print("Voer " + soort + " in: ");

        return ScanInput.scanInH();
    }

    public static int inputNumber(String question){
        String input = inputQuestion(question);
        if(ableToParse(input)){
            return Integer.parseInt(input);
        }else {
            Printer.printLine("Geen nummer!");
            inputNumber(question);
        }
        return 0;
    }
    public static double inputNumberD(String question){
        String input = inputQuestion(question);
        try {
            return Double.parseDouble(input);
        }catch (NumberFormatException e){
            Printer.printLine("Geen nummer!");
            inputNumberD(question);
        }
        return 0.0;
    }

    public static boolean ableToParse(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }




}

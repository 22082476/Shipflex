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

    public static String inputQuestion(String soort) {
        String input = "";

        while (input.equals("")){
            Printer.getInstance().print("Voer " + soort + " in: ");
            input = ScanInput.scanInH();

            if(input.equals("")){
                Printer.getInstance().printLine("Niks ingevuld!");
            }
        }
        return input;
    }

    public static int inputNumber(String question){
        String input = inputQuestion(question);
        int number;

        if (ableToParse(input)){
            number = Integer.parseInt(input);
        } else {
            Printer.getInstance().printLine("Geen nummer!");
            number = inputNumber(question);
        }

        return number;
    }
    public static double inputNumberD(String question){
        String input = inputQuestion(question);
        try {
            return Double.parseDouble(input);
        }catch (NumberFormatException e){
            Printer.getInstance().printLine("Geen nummer!");
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

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




}

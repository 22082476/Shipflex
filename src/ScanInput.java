import java.util.Scanner;

public class ScanInput {
    private static Scanner in = new Scanner(System.in);

    public static String scanIn(){
        return in.nextLine().toLowerCase();
    }
}

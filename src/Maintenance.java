import java.util.ArrayList;

public class Maintenance {
    private static ScanInput input = new ScanInput();

    public String askQuestionForStringInput(String question){
        System.out.println(question);
        return input.scanInH();
    }

    public int askQuestionForStringInt(String question) {
        System.out.println(question);
        return input.scanInInt();
    }
    public ArrayList<String> inleesinput() {
        ArrayList inleesinput = new ArrayList();
        while (!input.equals("stop")) {
            if (!inleesinput.equals("")) {
                inleesinput.add(input);
            }
        }
        return inleesinput;
    }
    public void start(){
        String input;
        input = askQuestionForStringInput("Commands: optie aanmaken");

        if(input.equalsIgnoreCase("optie aanmaken")) {
            Info.addOption(new Option(askQuestionForStringInput("Wat is de naam van het onderdeel?"), askQuestionForStringInt("Wat is de prijs van het onderdeel?"), askQuestionForStringInput("Wat voor soort onderdeel is het?"), askQuestionForStringInt("Wat is de korting?")));
        }

    }
}
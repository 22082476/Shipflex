import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Info {

    // hier moet nog een customer en company list
    private ArrayList<Option> options;

    Info() {
        this.options = new ArrayList<>();
    }

    public void readOptionsFromFile(String filePath) {

        String line = "";
        boolean isFirstLine = true;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            while((line = br.readLine()) != null) {

                if(isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] row = line.split(",");
                String[] essentialBoatTypes = row[4].split(";");
                String[] extraForBoatTypes = row[5].split(";");

                double price = Double.parseDouble(row[1]);
                int environmentDiscount = Integer.parseInt(row[3]);

                if(row.length > 6)
                    addOption(new Option(row[0], price, row[2], environmentDiscount, new ArrayList<String>(List.of(essentialBoatTypes)), new ArrayList<String>(List.of(extraForBoatTypes)), row[6]));
                else
                    addOption(new Option(row[0], price, row[2], environmentDiscount, new ArrayList<String>(List.of(essentialBoatTypes)), new ArrayList<String>(List.of(extraForBoatTypes))));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Option> getOptions() {
        return this.options;
    }

    public void addOption(Option option) {
        this.options.add(option);
    }


}

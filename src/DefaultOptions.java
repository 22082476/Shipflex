import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DefaultOptions {
    public void initOptions(String filePath, ShipBuilder shipBuilder) {

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

                double price = Double.parseDouble(row[1]);
                boolean environmentDiscount = Boolean.parseBoolean(row[3]);

                if(row.length > 4)
                    shipBuilder.addAvailableOption(new Option(row[0], price, row[2], environmentDiscount, row[4]));
                else
                    shipBuilder.addAvailableOption(new Option(row[0], price, row[2], environmentDiscount));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

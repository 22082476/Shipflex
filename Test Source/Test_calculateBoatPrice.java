import Boat.Boat;
import Boat.*;
import DataInOut.Info;
import Shipflex.Company;
import Shipflex.Quote;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_calculateBoatPrice {

    @Test
    public void testCalculateBoatPriceInflatableBoat() {
        // Arrange
        Info.readOptionsFromFile("src/data/options.csv");
        Boat myBoat = new InflatableBoat();
        Quote quote = new Quote(new Company("", "","","","",0), myBoat);

        // Act
        double resultPrice = quote.calculateBoatPrice();

        // Assert
        assertEquals(2595.99, resultPrice, 0.01);
    }

    @Test
    public void testCalculateBoatPriceInflatableBoat_WithOptions() {
        // Arrange
        Info.readOptionsFromFile("src/data/options.csv");
        Boat myBoat = new InflatableBoat();
        Quote quote = new Quote(new Company("", "","","","",0), myBoat);

        // Act
        quote.getBoat().addOptionsFromNames(new String[]{"Touw", });
        double resultPrice = quote.calculateBoatPrice();

        // Assert
        assertEquals(2620.99, resultPrice, 0.01);
    }

    @Test
    public void testCalculateBoatSpeedBoat() {
        // Arrange
        Info.readOptionsFromFile("src/data/options.csv");
        Boat myBoat = new SpeedBoat();
        Quote quote = new Quote(new Company("", "","","","",0), myBoat);

        // Act
        double resultPrice = quote.calculateBoatPrice();

        // Assert
        assertEquals(28084.97, resultPrice, 0.01);
    }

    @Test
    public void testCalculateBoatSpeedBoat_WithOptions() {
        // Arrange
        Info.readOptionsFromFile("src/data/options.csv");
        Boat myBoat = new SpeedBoat();
        Quote quote = new Quote(new Company("", "","","","",0), myBoat);

        // Act
        quote.getBoat().addOptionsFromNames(new String[]{"Touw", });
        double resultPrice = quote.calculateBoatPrice();

        // Assert
        assertEquals(28109.97, resultPrice, 0.01);
    }

    @Test
    public void testCalculateBoatPriceSailBoat() {
        // Arrange
        Info.readOptionsFromFile("src/data/options.csv");
        Boat myBoat = new SailBoat();
        Quote quote = new Quote(new Company("", "","","","",0), myBoat);

        // Act
        double resultPrice = quote.calculateBoatPrice();

        // Assert
        assertEquals(6104.99, resultPrice, 0.01);
    }

    @Test
    public void testCalculateBoatPriceSailBoat_WithOptions() {
        // Arrange
        Info.readOptionsFromFile("src/data/options.csv");
        Boat myBoat = new SailBoat();
        Quote quote = new Quote(new Company("", "","","","",0), myBoat);

        // Act
        quote.getBoat().addOptionsFromNames(new String[]{"Touw", "anker"});
        double resultPrice = quote.calculateBoatPrice();

        // Assert
        assertEquals(6129.99, resultPrice, 0.01);
    }

    @Test
    public void testCalculateBoatPricePleasureYacht() {
        // Arrange
        Info.readOptionsFromFile("src/data/options.csv");
        Boat myBoat = new PleasureYacht();
        Quote quote = new Quote(new Company("", "","","","",0), myBoat);

        // Act
        double resultPrice = quote.calculateBoatPrice();

        // Assert
        assertEquals(16324.98, resultPrice, 0.01);
    }

    @Test
    public void testCalculateBoatPricePleasureYacht_WithOptions() {
        // Arrange
        Info.readOptionsFromFile("src/data/options.csv");
        Boat myBoat = new PleasureYacht();
        Quote quote = new Quote(new Company("", "","","","",0), myBoat);

        // Act
        quote.getBoat().addOptionsFromNames(new String[]{"ReddingsVest", "lamp"});
        double resultPrice = quote.calculateBoatPrice();

        // Assert
        assertEquals(16398.98, resultPrice, 0.01);
    }
}





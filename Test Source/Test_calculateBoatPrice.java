import Boat.Boat;
import Boat.*;
import Shipflex.Company;
import Shipflex.Quote;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_calculateBoatPrice {
    @Test
    public void testCalculateBoatPrice() {
        // Arrange
        Company myCompany = new Company("Mijn Scheepswerf", "Hoofdstraat", "123AB", "Amsterdam", "Nederland", 12);
        //Boat myBoat = new Boat("rubberboot", "rubberboot", 2499.99);
        Boat myBoat = new InflatableBoat();
        myBoat.addOption();
        Quote myQuote = new Quote(myCompany, myBoat);
        //ParapluAnker,250.00,Anker,0,Speedboot,RubberBoot,deze anker is milieuvriendelijk
        double optie1Prijs = 250.00;

        //Yamaha,1900.00,BuitenboordMotor,10,Speedboot;PlezierJacht;RubberBoot,ZeilBoot,milieuvriendelijke motor
        double optie2Prijs = 1900.00;

        double expectedPrice = 0;
        expectedPrice += myBoat.getBasePrice() + optie1Prijs +optie2Prijs; // Base price + option1 price + option2 price

        // Act
        double actualPrice = myQuote.calculateBoatPrice();

        // Assert
        assertEquals(expectedPrice, actualPrice, 0.001); // Accept a difference up to 0.001 due to double precision
    }
}





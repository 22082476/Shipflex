package Test_AskCustomer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import DataInOut.Info;
import Shipflex.Company;
import Shipflex.MakeQuote;
import Shipflex.MakeQuoteCustomer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;


// deze test test of de waardes van de 4 verschillende customertypes wel goed worden aangeroepen.

public class Test_AskCustomer_MakeQuoteCustomer {

    @ParameterizedTest
    @CsvSource({"naam, straat, 1, 2589 EJ, Den Haag, Nederland, 0, naam, straat, 1, 2589 EJ, Den Haag, Nederland, 0,"})
    public void Test_AskCustomerCustomer(String name, String street, int houseNumber, String postcode, String city, String country, int percentage, String expectedName, String expectedStreet, int expectedHouseNumber, String expectedPostcode, String expectedCity, String expectedCountry, int expectedDiscount) throws IOException {
        //Arange
        Info.readOptionsFromFile("src/data/options.csv");
        MakeQuote makequote = new MakeQuote("rubberboot", new Company("", "", "", "", "", -1));
        MakeQuoteCustomer makequotecustomer = new MakeQuoteCustomer();


        //Act
        String inputData = "klant\n" + name + "\n" + street + "\n" + houseNumber + "\n" + postcode + "\n" + city + "\n" + country + "\n" + percentage + "\nnee";
        ByteArrayInputStream in = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(in);

        makequotecustomer.askCustomer();

        in.close();

        //Assert
        assertEquals(expectedName, MakeQuote.getQuote().getCustomer().getName());
        assertEquals(expectedStreet, MakeQuote.getQuote().getCustomer().getStreet());
        assertEquals(expectedHouseNumber, MakeQuote.getQuote().getCustomer().getHouseNumber());
        assertEquals(expectedPostcode, MakeQuote.getQuote().getCustomer().getPostcode());
        assertEquals(expectedCity, MakeQuote.getQuote().getCustomer().getCity());
        assertEquals(expectedCountry, MakeQuote.getQuote().getCustomer().getCountry());
        assertEquals(expectedDiscount, MakeQuote.getQuote().getCustomer().getDiscount());
    }
}

package Test_AskCustomer;

import DataInOut.Info;
import Shipflex.Company;
import Shipflex.MakeQuote;
import Shipflex.MakeQuoteCustomer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_AskCustomerFoundation_MakeQuoteCustomer {
    @ParameterizedTest
    @CsvSource({"naam, straat, 1, 2589 EJ, Den Haag, Nederland, 0, stichting, naam, straat, 1, 2589 EJ, Den Haag, Nederland, 0, stichting"})
    public void Test_AskCustomerFoundation(String name, String street, int houseNumber, String postcode, String city, String country, int percentage, String foundationName, String expectedName, String expectedStreet, int expectedHousenumber, String expectedPostcode, String expectedCity, String expectedCountry, int expectedDiscount, String expectedFoundationName) throws IOException {
        //Arange
        Info.readOptionsFromFile("src/data/options.csv");
        MakeQuote makequote = new MakeQuote("rubberboot", new Company("", "", 0, "", "", ""));
        MakeQuoteCustomer makequotecustomer = new MakeQuoteCustomer();

        //Act
        String inputData = "stichting\n" + name + "\n" + street + "\n" + houseNumber + "\n" + postcode + "\n" + city + "\n" + country + "\n" + percentage + "\n" + foundationName + "\nnee";
        ByteArrayInputStream in = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(in);

        makequotecustomer.askCustomer();

        in.close();

        //Assert
        assertEquals(expectedName, MakeQuote.getQuote().getFoundationCustomer().getName());
        assertEquals(expectedStreet, MakeQuote.getQuote().getFoundationCustomer().getStreet());
        assertEquals(expectedHousenumber, MakeQuote.getQuote().getFoundationCustomer().getHouseNumber());
        assertEquals(expectedPostcode, MakeQuote.getQuote().getFoundationCustomer().getPostcode());
        assertEquals(expectedCity, MakeQuote.getQuote().getFoundationCustomer().getCity());
        assertEquals(expectedCountry, MakeQuote.getQuote().getFoundationCustomer().getCountry());
        assertEquals(expectedDiscount, MakeQuote.getQuote().getFoundationCustomer().getDiscount());
        assertEquals(expectedFoundationName, MakeQuote.getQuote().getFoundationCustomer().getFoundation());
    }
}

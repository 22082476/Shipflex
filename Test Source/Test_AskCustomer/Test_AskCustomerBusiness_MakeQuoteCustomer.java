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

public class Test_AskCustomerBusiness_MakeQuoteCustomer {
    @ParameterizedTest
    @CsvSource({"naam, straat, 1, 2589 EJ, Den Haag, Nederland, 0, Shipflex, naam, straat, 1, 2589 EJ, Den Haag, Nederland, 0, Shipflex,"})
    public void Test_AskCustomerBusiness(String name, String street, int houseNumber, String postcode, String city, String country, int percentage, String companyName, String expectedName, String expectedStreet, int expectedHouseNumber, String expectedPostcode, String expectedCity, String expectedCountry, int expectedDiscount, String expectedCompanyName) throws IOException {
        //Arange
        Info.readOptionsFromFile("src/data/options.csv");
        MakeQuote makequote = new MakeQuote("rubberboot", new Company("", "", "", "", "", -1));
        MakeQuoteCustomer makequotecustomer = new MakeQuoteCustomer();

        //Act
        String inputData = "zakelijk\n" + name + "\n" + street + "\n" + houseNumber + "\n" + postcode + "\n" + city + "\n" + country + "\n" + percentage + "\n" + companyName + "\nnee";
        ByteArrayInputStream in = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(in);

        makequotecustomer.askCustomer();

        in.close();

        //Assert
        assertEquals(expectedName, MakeQuote.getQuote().getBusinessCustomer().getName());
        assertEquals(expectedStreet, MakeQuote.getQuote().getBusinessCustomer().getStreet());
        assertEquals(expectedHouseNumber, MakeQuote.getQuote().getBusinessCustomer().getHouseNumber());
        assertEquals(expectedPostcode, MakeQuote.getQuote().getBusinessCustomer().getPostcode());
        assertEquals(expectedCity, MakeQuote.getQuote().getBusinessCustomer().getCity());
        assertEquals(expectedCountry, MakeQuote.getQuote().getBusinessCustomer().getCountry());
        assertEquals(expectedDiscount, MakeQuote.getQuote().getBusinessCustomer().getDiscount());
        assertEquals(expectedCompanyName, MakeQuote.getQuote().getBusinessCustomer().getCompanyname());
    }
}

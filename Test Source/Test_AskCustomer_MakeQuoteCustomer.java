
import static org.junit.jupiter.api.Assertions.assertEquals;

import DataInOut.Info;
import Shipflex.Company;
import Shipflex.MakeQuote;
import Shipflex.MakeQuoteCustomer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;


// deze test test of de waardes van de 4 verschillende customertypes wel goed worden aangeroepen.
public class Test_AskCustomer_MakeQuoteCustomer {

    @ParameterizedTest
    @CsvSource({"naam, straat, 1, 2589 EJ, Den Haag, Nederland, 0, Shipflex, naam, straat, 1, 2589 EJ, Den Haag, Nederland, 0, Shipflex,"})
    public void Test_AskCustomerBussiness(String Name, String Street, int Housenumber, String Postcode, String Plaats, String Country, int Percentage, String Company, String expectedName, String expectedStreet, int expectedHousenumber, String expectedPostcode, String expectedPlaats, String expectedCountry, int expectedPercentage, String expectedCompany) {
        //Arange
        Info.readOptionsFromFile("src/data/options.csv");
        MakeQuote makequote = new MakeQuote("rubberboot", new Company("", "", "", "", "", 0));
        MakeQuoteCustomer makequotecustomer = new MakeQuoteCustomer();


        //Act
        String inputData = "zakelijk\nnaam\nstraat\n1\n2589 EJ\nDenHaag\nNederland\n0\nbedrijfsnaam\nnee";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        makequotecustomer.askCustomer();


        //Assert
        assertEquals(expectedName, MakeQuote.getQuote().getBusinessCustomer().getName());
        assertEquals(expectedStreet, MakeQuote.getQuote().getBusinessCustomer().getStreet());

    }




    @ParameterizedTest
    @CsvSource({"naam, straat, 1, 2589 EJ, Den Haag, Nederland, 0, Shipflex, naam, straat, 1, 2589 EJ, Den Haag, Nederland, 0, Shipflex,"})
    public void Test_AskCustomerFoundation(String Name, String Street, int Housenumber, String Postcode, String Plaats, String Country, int Percentage, String Company, String expectedName, String expectedStreet, int expectedHousenumber, String expectedPostcode, String expectedPlaats, String expectedCountry, int expectedPercentage, String expectedCompany) {
        //Arange
        Info.readOptionsFromFile("src/data/options.csv");
        MakeQuote makequote = new MakeQuote("rubberboot", new Company("", "", "", "", "", 0));
        MakeQuoteCustomer makequotecustomer = new MakeQuoteCustomer();


        //Act
        String inputData = "stichting\nnaam\nstraat\n1\n2589 EJ\nDenHaag\nNederland\n0\nbedrijfsnaam\nnee";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        makequotecustomer.askCustomer();


        //Assert
        assertEquals("naam", MakeQuote.getQuote().getFoundationCustomer().getName());
    }




    @ParameterizedTest
    @CsvSource({"naam, straat, 1, 2589 EJ, Den Haag, Nederland, 0, Shipflex, naam, straat, 1, 2589 EJ, Den Haag, Nederland, 0, Shipflex,"})
    public void Test_AskCustomerGoverment(String Name, String Street, int Housenumber, String Postcode, String Plaats, String Country, int Percentage, String Company, String expectedName, String expectedStreet, int expectedHousenumber, String expectedPostcode, String expectedPlaats, String expectedCountry, int expectedPercentage, String expectedCompany) {
        //Arange
        Info.readOptionsFromFile("src/data/options.csv");
        MakeQuote makequote = new MakeQuote("rubberboot", new Company("", "", "", "", "", 0));
        MakeQuoteCustomer makequotecustomer = new MakeQuoteCustomer();


        //Act
        String inputData = "overheid\nnaam\nstraat\n1\n2589 EJ\nDenHaag\nNederland\n0\nbedrijfsnaam\nnee";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        makequotecustomer.askCustomer();


        //Assert
        assertEquals("naam", MakeQuote.getQuote().getGovermentCustomer().getName());
    }



    @ParameterizedTest
    @CsvSource({"naam, straat, 1, 2589 EJ, Den Haag, Nederland, 0, Shipflex, naam, straat, 1, 2589 EJ, Den Haag, Nederland, 0, Shipflex,"})
    public void Test_AskCustomerCustomer(String Name, String Street, int Housenumber, String Postcode, String Plaats, String Country, int Percentage, String Company, String expectedName, String expectedStreet, int expectedHousenumber, String expectedPostcode, String expectedPlaats, String expectedCountry, int expectedPercentage, String expectedCompany){
        //Arange
        Info.readOptionsFromFile("src/data/options.csv");
        MakeQuote makequote = new MakeQuote("rubberboot", new Company("", "", "", "", "", 0));
        MakeQuoteCustomer makequotecustomer = new MakeQuoteCustomer();


        //Act
        String inputData = "klant\nnaam\nstraat\n1\n2589 EJ\nDenHaag\nNederland\n0\nnee";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        makequotecustomer.askCustomer();


        //Assert
        assertEquals("naam", MakeQuote.getQuote().getCustomer().getName());
    }
}
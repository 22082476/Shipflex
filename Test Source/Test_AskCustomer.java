
import static org.junit.jupiter.api.Assertions.assertEquals;

import Boat.Boat;
import Shipflex.Company;
import Shipflex.MakeQuote;
import Shipflex.MakeQuoteCustomer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;


// deze test test of de waardes van de 4 verschillende customertypes wel goed worden aangeroepen.
public class Test_AskCustomer {

    @ParameterizedTest
    @CsvSource({"naam, straat, 1, 2589 EJ, Den Haag, Nederland, 0, Shipflex, naam, straat, 1, 2589 EJ, Den Haag, Nederland, 0, Shipflex,"})
    public void Test_AskCustomerBussiness(String Name, String Street, int Housenumber, String Postcode, String Plaats, String Country, int Percentage, String Company, String expectedName, String expectedStreet, int expectedHousenumber, String expectedPostcode, String expectedPlaats, String expectedCountry, int expectedPercentage, String expectedCompany) {
        //Arange
        MakeQuote makequote = new MakeQuote("rubberboot", new Company("", "", "", "", "", 0));
        MakeQuoteCustomer makequotecustomer = new MakeQuoteCustomer();


        //Act
        String inputData = "zakelijk\nnaam\nstraat\n1\n2589 EJ\nDenHaag\nNederland\n0\nbedrijfsnaam\nstop";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        makequotecustomer.askCustomer();


        //Assert
        assertEquals("naam", MakeQuote.getQuote().getBusinessCustomer().getName());
        assertEquals("straat", MakeQuote.getQuote().getBusinessCustomer().getStreet());
        assertEquals("1", MakeQuote.getQuote().getBusinessCustomer().getHouseNumber());
        assertEquals("2589 EJ", MakeQuote.getQuote().getBusinessCustomer().getPostcode());
        assertEquals("DenHaag", MakeQuote.getQuote().getBusinessCustomer().getCity());
        assertEquals("Nederland", MakeQuote.getQuote().getBusinessCustomer().getCountry());
        assertEquals("0", MakeQuote.getQuote().getBusinessCustomer().getDiscount());
        assertEquals("ministerie", MakeQuote.getQuote().getBusinessCustomer().getCompany());

    }




    @ParameterizedTest
    @CsvSource({"naam, straat, 1, 2589 EJ, Den Haag, Nederland, 0, stichting, naam, straat, 1, 2589 EJ, Den Haag, Nederland, 0, stichting,"})
    public void Test_AskCustomerFoundation(String Name, String Street, int Housenumber, String Postcode, String Plaats, String Country, int Percentage, String Company, String expectedName, String expectedStreet, int expectedHousenumber, String expectedPostcode, String expectedPlaats, String expectedCountry, int expectedPercentage, String expectedCompany) {
        //Arange
        MakeQuote makequote = new MakeQuote("rubberboot", new Company("", "", "", "", "", 0));
        MakeQuoteCustomer makequotecustomer = new MakeQuoteCustomer();


        //Act
        String inputData = "stichting\nnaam\nstraat\n1\n2589 EJ\nDenHaag\nNederland\n0\nbedrijfsnaam\nstop";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        makequotecustomer.askCustomer();


        //Assert
        assertEquals("naam", MakeQuote.getQuote().getFoundationCustomer().getName());
        assertEquals("straat", MakeQuote.getQuote().getFoundationCustomer().getStreet());
        assertEquals("1", MakeQuote.getQuote().getFoundationCustomer().getHouseNumber());
        assertEquals("2589 EJ", MakeQuote.getQuote().getFoundationCustomer().getPostcode());
        assertEquals("DenHaag", MakeQuote.getQuote().getFoundationCustomer().getCity());
        assertEquals("Nederland", MakeQuote.getQuote().getFoundationCustomer().getCountry());
        assertEquals("0", MakeQuote.getQuote().getFoundationCustomer().getDiscount());
        assertEquals("stichting", MakeQuote.getQuote().getFoundationCustomer().getFoundation());    }




    @ParameterizedTest
    @CsvSource({"naam, straat, 1, 2589 EJ, Den Haag, Nederland, 0, ministerie, naam, straat, 1, 2589 EJ, Den Haag, Nederland, 0, ministerie,"})
    public void Test_AskCustomerGoverment(String Name, String Street, int Housenumber, String Postcode, String Plaats, String Country, int Percentage, String Company, String expectedName, String expectedStreet, int expectedHousenumber, String expectedPostcode, String expectedPlaats, String expectedCountry, int expectedPercentage, String expectedCompany) {
        //Arange
        MakeQuote makequote = new MakeQuote("rubberboot", new Company("", "", "", "", "", 0));
        MakeQuoteCustomer makequotecustomer = new MakeQuoteCustomer();


        //Act
        String inputData = "overheid\nnaam\nstraat\n1\n2589 EJ\nDenHaag\nNederland\n0\nbedrijfsnaam\nstop";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        makequotecustomer.askCustomer();


        //Assert
        assertEquals("naam", MakeQuote.getQuote().getGovermentCustomer().getName());
        assertEquals("straat", MakeQuote.getQuote().getGovermentCustomer().getStreet());
        assertEquals("1", MakeQuote.getQuote().getGovermentCustomer().getHouseNumber());
        assertEquals("2589 EJ", MakeQuote.getQuote().getGovermentCustomer().getPostcode());
        assertEquals("DenHaag", MakeQuote.getQuote().getGovermentCustomer().getCity());
        assertEquals("Nederland", MakeQuote.getQuote().getGovermentCustomer().getCountry());
        assertEquals("0", MakeQuote.getQuote().getGovermentCustomer().getDiscount());
        assertEquals("ministerie", MakeQuote.getQuote().getGovermentCustomer().getMinistry());
    }



    @ParameterizedTest
    @CsvSource({"naam, straat, 1, 2589 EJ, Den Haag, Nederland, 0, Shipflex, naam, straat, 1, 2589 EJ, Den Haag, Nederland, 0, Shipflex,"})
    public void Test_AskCustomerCustomer(String Name, String Street, int Housenumber, String Postcode, String Plaats, String Country, int Percentage, String Company, String expectedName, String expectedStreet, int expectedHousenumber, String expectedPostcode, String expectedPlaats, String expectedCountry, int expectedPercentage, String expectedCompany){
        //Arange
        MakeQuote makequote = new MakeQuote("rubberboot", new Company("", "", "", "", "", 0));
        MakeQuoteCustomer makequotecustomer = new MakeQuoteCustomer();


        //Act
        String inputData = "klant\nnaam\nstraat\n1\n2589 EJ\nDenHaag\nNederland\n0\nbedrijfsnaam\nstop";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        makequotecustomer.askCustomer();


        //Assert
        assertEquals("naam", MakeQuote.getQuote().getCustomer().getName());
        assertEquals("straat", MakeQuote.getQuote().getCustomer().getStreet());
        assertEquals("1", MakeQuote.getQuote().getCustomer().getHouseNumber());
        assertEquals("2589 EJ", MakeQuote.getQuote().getCustomer().getPostcode());
        assertEquals("DenHaag", MakeQuote.getQuote().getCustomer().getCity());
        assertEquals("Nederland", MakeQuote.getQuote().getCustomer().getCountry());
        assertEquals("0", MakeQuote.getQuote().getCustomer().getDiscount());

    }
}
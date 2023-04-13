
import static org.junit.jupiter.api.Assertions.assertEquals;

import Boat.Boat;
import Shipflex.Company;
import Shipflex.MakeQuote;
import Shipflex.MakeQuoteCustomer;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;



public class Test_AskCustomer {

    @Test //
    public void Test_AskCustomerBussiness(String Name, String Street, int Housenumber, int Postcode, String Plaats, String Country, int Percentage, String Company, String expectedName, String expectedStreet, int expectedHousenumber, int expectedPostcode, String expectedPlaats, String expectedCountry, int expectedPercentage, String expectedCompany) {
        //Arange
        MakeQuote makequote = new MakeQuote("rubberboot", new Company("", "", "", "", "", 0));
        MakeQuoteCustomer makequotecustomer = new MakeQuoteCustomer();


        //Act
        String inputData = "zakelijk\nnaam\nstraat\n1\n2589 EJ\nDenHaag\nNederland\n0\nbedrijfsnaam\nstop";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        makequotecustomer.askCustomer();


        //Assert
        assertEquals("naam", MakeQuote.getQuote().getBusinessCustomer().getName());

    }




    @Test
    public void Test_AskCustomerFoundation(String Name, String Street, int Housenumber, int Postcode, String Plaats, String Country, int Percentage, String Company, String expectedName, String expectedStreet, int expectedHousenumber, int expectedPostcode, String expectedPlaats, String expectedCountry, int expectedPercentage, String expectedCompany) {
        //Arange
        MakeQuote makequote = new MakeQuote("rubberboot", new Company("", "", "", "", "", 0));
        MakeQuoteCustomer makequotecustomer = new MakeQuoteCustomer();


        //Act
        String inputData = "stichting\nnaam\nstraat\n1\n2589 EJ\nDenHaag\nNederland\n0\nbedrijfsnaam\nstop";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        makequotecustomer.askCustomer();


        //Assert
        assertEquals("naam", MakeQuote.getQuote().getFoundationCustomer().getName());
    }




    @Test
    public void Test_AskCustomerGoverment(String Name, String Street, int Housenumber, int Postcode, String Plaats, String Country, int Percentage, String Company, String expectedName, String expectedStreet, int expectedHousenumber, int expectedPostcode, String expectedPlaats, String expectedCountry, int expectedPercentage, String expectedCompany) {
        //Arange
        MakeQuote makequote = new MakeQuote("rubberboot", new Company("", "", "", "", "", 0));
        MakeQuoteCustomer makequotecustomer = new MakeQuoteCustomer();


        //Act
        String inputData = "overheid\nnaam\nstraat\n1\n2589 EJ\nDenHaag\nNederland\n0\nbedrijfsnaam\nstop";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        makequotecustomer.askCustomer();


        //Assert
        assertEquals("naam", MakeQuote.getQuote().getGovermentCustomer().getName());
    }



    @Test
    public void Test_AskCustomerCustomer(String Name, String Street, int Housenumber, int Postcode, String Plaats, String Country, int Percentage, String Company, String expectedName, String expectedStreet, int expectedHousenumber, int expectedPostcode, String expectedPlaats, String expectedCountry, int expectedPercentage, String expectedCompany){
        //Arange
        MakeQuote makequote = new MakeQuote("rubberboot", new Company("", "", "", "", "", 0));
        MakeQuoteCustomer makequotecustomer = new MakeQuoteCustomer();


        //Act
        String inputData = "klant\nnaam\nstraat\n1\n2589 EJ\nDenHaag\nNederland\n0\nbedrijfsnaam\nstop";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        makequotecustomer.askCustomer();


        //Assert
        assertEquals("naam", MakeQuote.getQuote().getCustomer().getName());
    }
}
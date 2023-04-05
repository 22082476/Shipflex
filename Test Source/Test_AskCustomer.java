import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class Test_makeQuote {

    @ParameterizedTest
    @CsvSource({"zakelijk\\nNaam\\nStraatnaam\\n1234 AB\\nPlaatsnaam\\n1\\n10\\nBedrijfsnaam BV\", Naam, Straatnaam, 1234AB, Plaatsnaam, Huisnummer, Korting, Bedrijfsnaam", ""})
    public void Test_AskcustomerZakelijk(String InputStream, String expectedName, String expectedStreet, String expectedPostcode, String expectedCity, String expectedHouseNumber,int expectedDiscount, String expectedCompany) {
        //Arange
        ByteArrayInputStream in = new ByteArrayInputStream("zakelijk\nNaam\nStraatnaam\n1234 AB\nPlaatsnaam\n1\n10\nBedrijfsnaam BV".getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //Act
        Quote quote = new Quote();
        quote.askCustomer();

        //Assert
        assertEquals(expectedName, quote.getBusinessCustomer().getName());
        assertEquals(expectedStreet, quote.getBusinessCustomer().getStreet());
        assertEquals(expectedPostcode, quote.getBusinessCustomer().getPostcode());
        assertEquals(expectedCity, quote.getBusinessCustomer().getCity());
        assertEquals(expectedHouseNumber, qoute.getBusinessCustomer().getHouseNumber());
        assertEquals(expectedDiscount, quote.getBusinessCustomer().getDiscount());
        assertEquals(expectedCompany, quote.getBusinessCustomer().getCompany());
    }

    @ParameterizedTest
    @CsvSource({"overheid\\nNaam\\nStraatnaam\\n1234 AB\\nPlaatsnaam\\n1\\n10\\nBedrijfsnaam BV\", Naam, Straatnaam, 1234AB, Plaatsnaam, Huisnummer, Korting, Overheidsnaam", ""})
    public void Test_AskcustomerGoverment(String InputStream, String expectedName, String expectedStreet, String expectedPostcode, String expectedCity, String expectedHouseNumber, int expectedDiscount, String expectedMinisty){
        //Arange
        ByteArrayInputStream in = new ByteArrayInputStream("overheid\nNaam\nStraatnaam\n1234 AB\nPlaatsnaam\n1\n10\nOverheidsnaam".getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //Act
        Quote quote = new Quote();
        quote.askCustomer();

        //Assert
        assertEquals(expectedName, quote.getBusinessCustomer().getName());
        assertEquals(expectedStreet, quote.getBusinessCustomer().getStreet());
        assertEquals(expectedPostcode, quote.getBusinessCustomer().getPostcode());
        assertEquals(expectedCity, quote.getBusinessCustomer().getCity());
        assertEquals(expectedHouseNumber, qoute.getBusinessCustomer().getHouseNumber());
        assertEquals(expectedDiscount, quote.getBusinessCustomer().getDiscount());
        assertEquals(expectedMinisty, quote.getBusinessCustomer().getMinisty());
    }

    @ParameterizedTest
    @CsvSource({"Klant\\nNaam\\nStraatnaam\\n1234 AB\\nPlaatsnaam\\n1\\n10\", Naam, Straatnaam, 1234AB, Plaatsnaam, Huisnummer, Korting", ""})
    public void Test_AskcustomerCustomer(String InputStream, String expectedName, String expectedStreet, String expectedPostcode, String expectedCity, String expectedHouseNumber, int expectedDiscount){
        //Arange
        ByteArrayInputStream in = new ByteArrayInputStream("klant\nNaam\nStraatnaam\n1234 AB\nPlaatsnaam\n1\n10".getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //Act
        Quote quote = new Quote();
        quote.askCustomer();

        //Assert
        assertEquals(expectedName, quote.getBusinessCustomer().getName());
        assertEquals(expectedStreet, quote.getBusinessCustomer().getStreet());
        assertEquals(expectedPostcode, quote.getBusinessCustomer().getPostcode());
        assertEquals(expectedCity, quote.getBusinessCustomer().getCity());
        assertEquals(expectedHouseNumber, qoute.getBusinessCustomer().getHouseNumber());
        assertEquals(expectedDiscount, quote.getBusinessCustomer().getDiscount());
    }

    @ParameterizedTest
    @CsvSource({"Stichting\\nNaam\\nStraatnaam\\n1234 AB\\nPlaatsnaam\\n1\\n10\\nStichtingnaam\", Naam, Straatnaam, 1234AB, Plaatsnaam, Huisnummer, Korting, Stichtingsnaam", ""})
    public void Test_AskcustomerFoundation(String InputStream, String expectedName, String expectedStreet, String expectedPostcode, String expectedCity, String expectedHouseNumber, int expectedDiscount, String expectedFoundation){
        //Arange
        ByteArrayInputStream in = new ByteArrayInputStream("stichting\nNaam\nStraatnaam\n1234 AB\nPlaatsnaam\n1\n10\nStichtingsnaam".getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //Act
        Quote quote = new Quote();
        quote.askCustomer();

        //Assert
        assertEquals(expectedName, quote.getBusinessCustomer().getName());
        assertEquals(expectedStreet, quote.getBusinessCustomer().getStreet());
        assertEquals(expectedPostcode, quote.getBusinessCustomer().getPostcode());
        assertEquals(expectedCity, quote.getBusinessCustomer().getCity());
        assertEquals(expectedHouseNumber,qoute.getBusinessCustomer().getHouseNumber());
        assertEquals(expectedDiscount, quote.getBusinessCustomer().getDiscount());
        assertEquals(expectedFoundation, quote.getBusinessCustomer().getFoundation());
    }
}


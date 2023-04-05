import static org.testng.Assert.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class Test_AskCustomer {

    @ParameterizedTest
    @CsvSource({"zakelijk\\nNaam\\nStraatnaam\\n1234 AB\\nPlaatsnaam\\n1\\n10\\nBedrijfsnaam BV\", Naam, Straatnaam, 1234AB, Plaatsnaam, Huisnummer, Korting, Bedrijfsnaam", ""})
    public void Test_AskcustomerZakelijk(String InputStream, String expectedName, String expectedStreet, String expectedPostcode, String expectedCity, String expectedHouseNumber, int expectedDiscount, String expectedCompany) {
        //Arange
        ByteArrayInputStream in = new ByteArrayInputStream("zakelijk\nNaam\nStraatnaam\n1234 AB\nPlaatsnaam\n1\n10\nBedrijfsnaam BV".getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //Act
        Quote quote = new Quote(new Company("bedrijf1","straat1","1234rt", "Den haag",4),new Boat("speedboot1", "speedboot",30000));
        MakeQuote quote1 = new MakeQuote("speedboot",new Company("bedrijf1","straat1","1234rt", "Den haag",4));
        quote1.askCustomer();

        //Assert
        assertEquals(expectedName, quote.getBusinessCustomer().getName());
        assertEquals(expectedStreet, quote.getBusinessCustomer().getStreet());
        assertEquals(expectedPostcode, quote.getBusinessCustomer().getPostcode());
        assertEquals(expectedCity, quote.getBusinessCustomer().getCity());
        assertEquals(expectedHouseNumber, quote.getBusinessCustomer().getHouseNumber());
        assertEquals(expectedDiscount, quote.getBusinessCustomer().getDiscount());
        assertEquals(expectedCompany, quote.getBusinessCustomer().getCompany());
    }

}
/*
    @ParameterizedTest
    @CsvSource({"overheid\\nNaam\\nStraatnaam\\n1234 AB\\nPlaatsnaam\\n1\\n10\\nBedrijfsnaam BV\", Naam, Straatnaam, 1234AB, Plaatsnaam, Huisnummer, Korting, Overheidsnaam", ""})
    public void Test_AskcustomerGoverment(String expectedName, String expectedStreet, String expectedPostcode, String expectedCity, String expectedHouseNumber, int expectedDiscount, String expectedMinisty){
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
        assertEquals(expectedHouseNumber, quote.getBusinessCustomer().getHouseNumber());
        assertEquals(expectedDiscount, quote.getBusinessCustomer().getDiscount());
        assertEquals(expectedMinisty, quote.getBusinessCustomer().getCustomer());
    }

}

    @ParameterizedTest
    @CsvSource({"Klant\\nNaam\\nStraatnaam\\n1234 AB\\nPlaatsnaam\\n1\\n10\", Naam, Straatnaam, 1234AB, Plaatsnaam, Huisnummer, Korting", ""})
    public void Test_AskcustomerCustomer(String expectedName, String expectedStreet, String expectedPostcode, String expectedCity, String expectedHouseNumber, int expectedDiscount){
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
        assertEquals(expectedHouseNumber, quote.getBusinessCustomer().getHouseNumber());
        assertEquals(expectedDiscount, quote.getBusinessCustomer().getDiscount());
    }

    @ParameterizedTest
    @CsvSource({"Stichting\\nNaam\\nStraatnaam\\n1234 AB\\nPlaatsnaam\\n1\\n10\\nStichtingnaam\", Naam, Straatnaam, 1234AB, Plaatsnaam, Huisnummer, Korting, Stichtingsnaam", ""})
    public void Test_AskcustomerFoundation(String expectedName, String expectedStreet, String expectedPostcode, String expectedCity, String expectedHouseNumber, int expectedDiscount, String expectedFoundation){
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
        assertEquals(expectedHouseNumber,quote.getBusinessCustomer().getHouseNumber());
        assertEquals(expectedDiscount, quote.getBusinessCustomer().getDiscount());
        assertEquals(expectedFoundation, quote.getBusinessCustomer().getFoundation());
    }
}

*/


import static org.junit.jupiter.api.Assertions.assertEquals;

import Boat.Boat;
import Shipflex.Company;
import Shipflex.MakeQuote;
import Shipflex.MakeQuoteCustomer;
import Shipflex.Quote;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class Test_AskCustomer {

    @Test //
    public void Test_AskcustomerZakelijk() {
        //Arange
        MakeQuote makequote = new MakeQuote();
        MakeQuoteCustomer makequotecustomer = new MakeQuoteCustomer();



        //Act
        String inputData = "zakelijk\nnaam\nstraat\n1\n2589 EJ\nDenHaag\nNederland\n0\nbedrijfsnaam";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        makequotecustomer.askCustomer();


        //Assert
        assertEquals(makequotecustomer.);


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


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test_makeQuote {
    @Test
    public void Test_AskcustomerZakelijk() {
        //Arange
        ByteArrayInputStream in = new ByteArrayInputStream("zakelijk\nNaam\nStraatnaam\n1234 AB\nPlaatsnaam\n1\n10\nBedrijfsnaam BV".getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //Act
        Quote quote = new Quote();
        quote.askCustomer();

        //Assert
        assertEquals("Naam", quote.getBusinessCustomer().getName());
        assertEquals("Straatnaam", quote.getBusinessCustomer().getStreet());
        assertEquals("1234 AB", quote.getBusinessCustomer().getPostcode());
        assertEquals("Stad", quote.getBusinessCustomer().getCity());
        assertEquals("Huisnummer", qoute.getBusinessCustomer().getHouseNumber());
        assertEquals(10, quote.getBusinessCustomer().getDiscount());
        assertEquals("Bedrijfsnaam BV", quote.getBusinessCustomer().getCompany());
    }

    @Test
    public void Test_AskcustomerGoverment(){
            //Arange
            ByteArrayInputStream in = new ByteArrayInputStream("overheid\nNaam\nStraatnaam\n1234 AB\nPlaatsnaam\n1\n10\nOverheidsnaam".getBytes());
            System.setIn(in);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));

            //Act
            Quote quote = new Quote();
            quote.askCustomer();

            //Assert
            assertEquals("Naam", quote.getBusinessCustomer().getName());
            assertEquals("Straatnaam", quote.getBusinessCustomer().getStreet());
            assertEquals("1234 AB", quote.getBusinessCustomer().getPostcode());
            assertEquals("Stad", quote.getBusinessCustomer().getCity());
            assertEquals("Huisnummer", qoute.getBusinessCustomer().getHouseNumber());
            assertEquals(10, quote.getBusinessCustomer().getDiscount());
            assertEquals("Overheidsnaam", quote.getBusinessCustomer().getMinisty());
        }
    }
    @Test
    public void Test_AskcustomerCustomer(){
        //Arange
        ByteArrayInputStream in = new ByteArrayInputStream("klant\nNaam\nStraatnaam\n1234 AB\nPlaatsnaam\n1\n10".getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //Act
        Quote quote = new Quote();
        quote.askCustomer();

        //Assert
        assertEquals("Naam", quote.getBusinessCustomer().getName());
        assertEquals("Straatnaam", quote.getBusinessCustomer().getStreet());
        assertEquals("1234 AB", quote.getBusinessCustomer().getPostcode());
        assertEquals("Plaatsnaam", quote.getBusinessCustomer().getCity());
        assertEquals("Huisnummer", qoute.getBusinessCustomer().getHouseNumber());
        assertEquals(10, quote.getBusinessCustomer().getDiscount());
    }

    @Test
    public void Test_AskcustomerFoundation(){
        //Arange
        ByteArrayInputStream in = new ByteArrayInputStream("stichting\nNaam\nStraatnaam\n1234 AB\nPlaatsnaam\n1\n10\nStichtingsnaam".getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //Act
        Quote quote = new Quote();
        quote.askCustomer();

        //Assert
        assertEquals("Naam", quote.getBusinessCustomer().getName());
        assertEquals("Straatnaam", quote.getBusinessCustomer().getStreet());
        assertEquals("1234 AB", quote.getBusinessCustomer().getPostcode());
        assertEquals("Stad", quote.getBusinessCustomer().getCity());
        assertEquals("Huisnummer", qoute.getBusinessCustomer().getHouseNumber());
        assertEquals(10, quote.getBusinessCustomer().getDiscount());
        assertEquals("Stichtingsnaam", quote.getBusinessCustomer().getFoundation());
    }
}
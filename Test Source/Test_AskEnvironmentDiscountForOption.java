import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test_AskEnvironmentDiscountForOption {

    @Test
    public void testAskEnvironmentDiscountForOption() {
        // Set up test object
        Option option = new Option("Talamex anker", 499,99  , "Anker", 10, );

        // Test valid input
        setInput("50");
        askEnvironmentDiscountForOption(option);
        assertEquals(50, option.getEnvironmentDiscount());
        assertTrue(getOutput().contains("Je hebt 50% milieukorting toegevoegd aan optie"));

        // Test invalid input (not a number)
        setInput("not a number");
        askEnvironmentDiscountForOption(option);
        assertEquals(50, option.getEnvironmentDiscount());
        assertTrue(getOutput().contains("Geen nummer ingevuld!"));

        // Test invalid input (out of range)
        setInput("200");
        setInput("30");
        askEnvironmentDiscountForOption(option);
        assertEquals(30, option.getEnvironmentDiscount());
        assertTrue(getOutput().contains("Vul een getal in boven 0 en onder de 100!"));
    }
}

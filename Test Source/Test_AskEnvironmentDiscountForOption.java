import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Reporter.getOutput;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Test_AskEnvironmentDiscountForOption {

    private String input;

    @Test
    public void testAskEnvironmentDiscountForOption() {
        // Set up test object
        Option option = new Option("Talamex anker", 499, "anker",7,new ArrayList<String>(Arrays.asList("motor")),new ArrayList<String>(Arrays.asList("touw")));

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
    public void setInput(String input) {
        this.input = input;
    }

    public void askEnvironmentDiscountForOption(Option option) {
        try {
            int discount = Integer.parseInt(input);
            if (discount >= 0 && discount <= 100) {
                option.setEnvironmentDiscount(discount);
                System.out.println("Je hebt " + discount + "% milieukorting toegevoegd aan optie");
            } else {
                System.out.println("Vul een getal in boven 0 en onder de 100!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Geen nummer ingevuld!");
        }
    }
}




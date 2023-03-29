

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Test_makeQuote {


    @Test
    public void Test_test_zakelijk(){
        //Arrange
        String typeCustomer = "Zakelijk";

        //Act
        Customer customer = new Customer("Merel Weenstra","Katerstraat", "5655 KB", "Den Haag", 58, 10);

        //Assert
        assertEquals("Merel Weenstra", customer.getName());
        assertEquals("Katerstraat", customer.getStreet());
        assertEquals("5655 KB", customer.getPostcode());
        assertEquals("Den Haag", customer.getCity());
        assertEquals(58, customer.getHouseNumber());
        assertEquals(10, customer.getDiscount());
    }
}

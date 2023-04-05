import Boat.Option;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_BerekeningMileuKorting {


    @ParameterizedTest
    @CsvSource ({"10, 44.99, 40.49", "10, 500.00, 450.00","10, 9.99, 8.99", "10, 2499.99, 2249.99", "25, 150.95, 113.21", "13, 69.99,  60.89" })
    public void CorrecteUitvoer_calculateEnvironmentDiscount(int percentage, double price, double expected){
        //Arrange
        Option option = new Option("", price, "", percentage, new ArrayList<String>(), new ArrayList<String>());

        //Act
        double actual = option.calculateEnvironmentDiscount();

        //Assert
        assertEquals(expected, actual, 0.009);

    }
}

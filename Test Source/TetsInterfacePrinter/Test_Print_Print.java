package TetsInterfacePrinter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_Print_Print {
    @ParameterizedTest
    @CsvSource({"testen, testen"})
    public void testPrint(String text, String expected){
        //Arrange
        TestClassPrinterInterface printer = new TestClassPrinterInterface();

        //Act
        printer.print(text);

        //Assert
        assertEquals(expected, printer.outCome);
    }
}

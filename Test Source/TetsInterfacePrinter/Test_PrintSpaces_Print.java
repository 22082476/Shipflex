package TetsInterfacePrinter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_PrintSpaces_Print {
    @ParameterizedTest
    @CsvSource({"5, '     '", "0, ''", "7, '       '"})
    public void testPrintSpaces(int number, String expected) {
        //Arrange
        TestClassPrinterInterface printer = new TestClassPrinterInterface();

        //Act
        printer.printSpaces(number);

        //Assert
        assertEquals(expected, printer.outCome);
    }
}

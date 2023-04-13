package TetsInterfacePrinter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_PrintLine_Test {
    @ParameterizedTest
    @CsvSource({"testers, "})
    public void testPrintLine(String text, String expected) {
        //Arrange
        TestClassPrinterInterface printer = new TestClassPrinterInterface();

        //Act
        printer.printLine(text);

        //Assert
        assertEquals(text, TestClassPrinterInterface.outCome);
    }
}

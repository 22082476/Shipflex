package TetsInterfacePrinter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_PrintFormatInfo_Print {
    //test of de output wel goed word geformat, dus dat er na de String 30 spaces bijkomen
    @Test
    @ParameterizedTest
    @CsvSource({"test12, test12                              "})
    public void testPrintFormatInfo() {
        //Arrange
        TestClassPrinterInterface printer = new TestClassPrinterInterface();

        //Act
        printer.printFormatInfo("test12");

        //Assert
        assertEquals("test12                              ", TestClassPrinterInterface.outCome);
    }
}

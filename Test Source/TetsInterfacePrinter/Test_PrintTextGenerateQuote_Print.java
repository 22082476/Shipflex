package TetsInterfacePrinter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_PrintTextGenerateQuote_Print {

    @Test
    public void testPrintTextGenerateQuote() {
        //Arrange
        TestClassPrinterInterface printer = new TestClassPrinterInterface();

        //Act
        printer.printTextGenerateQuote(new String[]{"een", "twee", "drie", "vier"});

        //Assert
        assertEquals("Commands: [0] een, [1] twee, [2] drie, [3] vier Voer een command in: ", printer.outCome);
    }
}

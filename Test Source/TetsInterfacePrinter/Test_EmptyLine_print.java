package TetsInterfacePrinter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_EmptyLine_print {
    @Test
    public void testEmptyLine() {
        //Arrange
        TestClassPrinterInterface printer = new TestClassPrinterInterface();

        //Act
        printer.emptyLine();

        //Assert
        assertEquals(" <<lege regel>> ", printer.outCome);
    }
}

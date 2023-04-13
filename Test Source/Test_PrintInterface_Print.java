import DataInOut.Print;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TestClassPrinterInterface implements Print {
protected static String outCome = null;
    @Override
    public void print(String text) {
        this.outCome = text;
    }

    @Override
    public void printLine(String text) {
        this.outCome = text;
    }

    @Override
    public void emptyLine() {
        this.outCome = " <<lege regel>> ";
    }

    @Override
    public void printSpaces(int number) {
        String spaces = "";

        for (int i = 1; i <= number; i++) {
            spaces += " ";
        }
        this.outCome = spaces;

    }

    @Override
    public void printCharacters(int number, char character) {

    }

    @Override
    public void printTextGenerateQuote(String[] input) {
        String output = "Commands: ";
        for(int i = 0; i < input.length; i++){
            if(i == input.length-1){
                output += "[" +i+ "] " + input[i];
            }else {
                output += "[" +i+ "] " + input[i] + ", ";
            }

            if (i == input.length / 2 && input.length >= 4)
                emptyLine();
        }
        outCome = output + " Voer een command in: ";
    }


    @Override
    public void printFormatInfo(String property) {
        int amountOfSpaces = 30;

        String output = property;

        for (int i = 1; i <= amountOfSpaces; i++) {
            output += " ";
        }
    }

}



class Test_PrinterInterface_Print {
    @ParameterizedTest
    @CsvSource({"testen, "})
    public void testPrint(String text, String expected){
        //Arrange
        TestClassPrinterInterface printer = new TestClassPrinterInterface();

        //Act
        printer.print(text);

        //Assert
        assertEquals(expected, TestClassPrinterInterface.outCome);
    }

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

    @Test
    public void testEmptyLine() {
        //Arrange
        TestClassPrinterInterface printer = new TestClassPrinterInterface();

        //Act
        printer.emptyLine();

        //Assert
        assertEquals(" <<lege regel>> ", printer.outCome);
    }

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

    @Test
    public void testPrintTextGenerateQuote() {
        //Arrange
        TestClassPrinterInterface printer = new TestClassPrinterInterface();

        //Act
        printer.printTextGenerateQuote(new String[]{"een", "twee", "drie", "vier"});

        //Assert
        assertEquals("Commands: [0] een, [1] twee, [2] drie, [3] vier Voer een command in: ", TestClassPrinterInterface.outCome);
    }


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

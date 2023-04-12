import DataInOut.Print;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TestClassPrinterInterface implements Print {
protected static String outCome = null;

@Test
public void testPrint(){
    //Arrange
    Print printer = new TestClassPrinterInterface();
    String text = "testen";
    //Act
    printer.print(text);
    //Assert
    Assertions.assertEquals(text,outCome);
}

    @Test
    public void testPrintLine() {
        //Arrange
        Print printer = new TestClassPrinterInterface();
        String text = "testers";
        //Act
        printer.printLine(text);
        //Assert
        Assertions.assertEquals(text, outCome);
    }

    @Test
    public void testEmptyLine() {
        //Arrange
        Print printer = new TestClassPrinterInterface();
        //Act
        printer.emptyLine();
        //Assert
        Assertions.assertEquals(" <<lege regel>> ", outCome);
    }

    @Test
    public void testPrintSpaces() {
        //Arrange
        Print printer = new TestClassPrinterInterface();
        int number = 5;
        //Act
        printer.printSpaces(number);
        //Assert
        Assertions.assertEquals("     ", outCome);
    }

    @Test
    public void testPrintTextGenerateQuote() {
        //Arrange
        Print printer = new TestClassPrinterInterface();
        String[] input = {"Optie 1", "Optie 2", "Optie 3"};
        //Act
        printer.printTextGenerateQuote(input);
        String expectedOutput = "Commands: [0] Optie 1, [1] Optie 2, [2] Optie 3 Voer een command in: ";
        //Assert
        Assertions.assertEquals(expectedOutput, outCome);

        //Arrange
        input = new String[]{"Boot 1", "Boot 2", "Boot 3", "Boot 4", "Boot 5"};
        //Act
        printer.printTextGenerateQuote(input);
        expectedOutput = "Commands: [0] Boot 1, [1] Boot 2, [2] Boot 3, [3] Boot 4, [4] Boot 5 Voer een command in: ";
        //Assert
        Assertions.assertEquals(expectedOutput, outCome);
    }


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

}

package TetsInterfacePrinter;

import DataInOut.Print;



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

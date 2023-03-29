import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_InfoReadFile {

    @ParameterizedTest
    @CsvSource ({"src/data/options.csv, 25"})
    public void Correcte_aatalRegelsMetInlezenInfo(String source, int aantalRijen){
        //Arrange
        Info.readOptionsFromFile(source);
        ArrayList<Option> temp = null;
        //Act
        temp = Info.getOptions();

        //Assert
        assertEquals(aantalRijen, temp.size());

    }
}

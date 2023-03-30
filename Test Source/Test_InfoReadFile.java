import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_InfoReadFile {

    @ParameterizedTest
    @CsvSource ({"src/data/options.csv, 25", "src/data/options2.csv, 50", "src/data/test2.csv, 56"})
    public void Correcte_aatalRegelsMetInlezenInfo(String source, int expectedRowNumbers){
        //Arrange
        Info.readOptionsFromFile(source);
        ArrayList<Option> temp = null;
        //Act
        temp = Info.getOptions();

        //Assert
        assertEquals(expectedRowNumbers, temp.size());

    }
}

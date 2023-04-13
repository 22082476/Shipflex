import Boat.Option;
import DataInOut.Info;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_readOptionsFromFile_Info {

    @ParameterizedTest
    @CsvSource ({"src/data/options.csv, 28", "src/data/options2.csv, 25", "src/data/test2.csv, 6"})
    public void testReadOptionsFromFile(String source, int expectedRowNumbers){
        //Arrange
        Info.readOptionsFromFile(source);
        List<Option> temp = null;
        //Act
        temp = Info.getOptions();

        //Assert
        assertEquals(expectedRowNumbers, temp.size());
    }
}

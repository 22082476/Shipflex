import Shipflex.Maintenance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_ParseBoatTextToList_Maintenance {

    @ParameterizedTest
    @CsvSource({"rubberboot, zeilboot, speedboot"})
    public void testParseBoatTextToList(String expectedOne, String expectedTwo, String expectedThree) {
        //Arrange
        Maintenance maintenance = new Maintenance();
        ArrayList<String> expected = new ArrayList<>();
        expected.add(expectedOne);
        expected.add(expectedTwo);
        expected.add(expectedThree);


        //Act
        String inputData = expectedOne + ", " + expectedTwo + ", " + expectedThree +  "\n";

        ByteArrayInputStream in = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(in);

        ArrayList<String> result = maintenance.parseBoatTextToList("de testje");


        //Assert
        assertEquals(expected, result);
    }

}

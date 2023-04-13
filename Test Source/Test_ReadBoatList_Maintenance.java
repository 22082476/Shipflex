import Shipflex.Maintenance;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_ReadBoatList_Maintenance {
    @Test
    public void testReadBoatList() {
        //Arrange
        Maintenance maintenance = new Maintenance();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("yes");
        expected.add("nest");

        //Act
        String inputData = "yes\nnest\nstop";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        ArrayList<String> result = maintenance.readBoatList("de testje");

        assertEquals(expected, result);
    }

}

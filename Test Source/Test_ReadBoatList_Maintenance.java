import Shipflex.Maintenance;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_ReadBoatList_Maintenance {
    @Test
    public void testReadBoatList() throws IOException {
        //Arrange
        Maintenance maintenance = new Maintenance();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("yes");
        expected.add("nest");

        //Act
        String inputData = "yes\nnest\nstop";

        ByteArrayInputStream in = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(in);

        ArrayList<String> result = maintenance.readTypeBoatList("de testje");

        in.close();

        //Assert
        assertEquals(expected, result);
    }

}

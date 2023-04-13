import Shipflex.Maintenance;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_ReadBoatList {
    @Test
    public void testReadBoatList() {
        Maintenance maintenance = new Maintenance();

        ArrayList<String> expected = new ArrayList<>();

        expected.add("yes");
        expected.add("nest");

        String inputData = "yes\nnest\nstop";

        System.setIn(new ByteArrayInputStream(inputData.getBytes()));

        ArrayList<String> result = maintenance.readBoatList("de testje");

        assertEquals(expected, result);
    }

}

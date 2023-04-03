import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test_BootType {
    @Test
    public void testGetFromTypeBoat() {
        Boat boat;

        // Test for PleasureYacht
        boat = getFromTypeBoat("plezier jacht");
        assertTrue(boat instanceof PleasureYacht);

        // Test for InflatableBoat
        boat = getFromTypeBoat("rubberboot");
        assertTrue(boat instanceof InflatableBoat);

        // Test for SpeedBoat
        boat = getFromTypeBoat("speedboot");
        assertTrue(boat instanceof SpeedBoat);

        // Test for SailBoat
        boat = getFromTypeBoat("zeilboot");
        assertTrue(boat instanceof SailBoat);

        // Test for invalid boat type
        boat = getFromTypeBoat("invalid");
        assertNull(boat);
    }
}


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public Boat getFromTypeBoat(String type) {
        switch(type.toLowerCase()) {
            case "plezier jacht":
                return new PleasureYacht();
            case "rubberboot":
                return new InflatableBoat();
            case "speedboot":
                return new SpeedBoat();
            case "zeilboot":
                return new SailBoat();
            default:
                return null;
        }
    }
}



import java.util.ArrayList;

public class Boat {

    String name;
    String type;
    Double baseprice;

    Boat(String name, String type, Double baseprice){
        this.name = name;
        this.type = type;
        this.baseprice = baseprice;
    }

    ArrayList<Option>options = new ArrayList<>();
    ArrayList<Option>extraOptions = new ArrayList<>();

}

import java.util.ArrayList;

public class Boat {

    String name;
    String type;

    Boat(String name, String type){
        this.name = name;
        this.type = type;
    }

    ArrayList<Option>options = new ArrayList<>();
    ArrayList<Option>extraOptions = new ArrayList<>();

}

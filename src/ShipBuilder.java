import java.util.ArrayList;

public class ShipBuilder {
    private ArrayList<Option> availableOptions;

    ShipBuilder() {
        this.availableOptions = new ArrayList<>();
    }

    public void addAvailableOption(Option option) {
        this.availableOptions.add(option);
    }

    public void alterAvailableOption(Option option, Option newOption) {
        int optionIndex = this.availableOptions.indexOf(option);
        this.availableOptions.set(optionIndex, newOption);
    }

    public void removeAvailableOption(Option option) {
        this.availableOptions.remove(option);
    }

    public ArrayList<Option> getAvailableOptions() {
        return this.availableOptions;
    }
}

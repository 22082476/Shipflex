public class MakeQuote {
    private String boatType;
    private Boat boat;
    private Quote quote;
    private Info dataInput = new Info();

    public MakeQuote(String boatType){
        this.boatType = boatType;
        this.quote = new Quote();
        this.boat = getFromTypeBoat(this.boatType);
    }

    public Boat getFromTypeBoat(String boatType){
        if(boatType.equals("plezier jacht")){
            return new PleasureYacht();
        }

    }
}

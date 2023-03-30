public class Maintenance {
    private static ScanInput in = new ScanInput();
    public String maintenance = in.scanInL();

    public void CheckInput(){
        String inputstr = ScanInput.scanInL();
        while(true) {
            inputstr = ScanInput.scanInL();
            break;
        }
        System.out.println("Welke optie wilt u toevoegen?") ;
    }

    public void start(){
        String inputstr = ScanInput.scanInL();
        while(true) {

            if (inputstr.equals("opties toevoegen")) {
                inputstr = ScanInput.scanInL();
            }
            else if (inputstr.equals("stop")) {
                break;
            }else if(inputstr.equals("voeg optie toe")) {
                inputstr = ScanInput.scanInL();
            }else if(inputstr.equals("laat klant zien")){
                inputstr = ScanInput.scanInL();
            } else {
                System.out.println("Incorrecte invoer!");
                System.out.println("probeer opniew");
                inputstr = ScanInput.scanInL();
            }
        }
    }
}
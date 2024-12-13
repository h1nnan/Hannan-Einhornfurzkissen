import Utills.Client;

public class ShopClient extends Client {

    ShopClient(String pServerIP, int pServerPort) {
        super(pServerIP, pServerPort);
    }

    public void groesse FarbeWaehlen(String pGroesse, String pFarbe){
        this.send("Einhornfurzkissen: "+ pGroesse+":"+pFarbe);
    }

    public void bestaetigen(String pAntwort){
        this.send ("BESTAETIGUNG:"+ pAntwort);
    }

    public void abmelden() {
        this.send("ABMELDEN");
    }
}

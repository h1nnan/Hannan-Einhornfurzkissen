import Utills.List;
import Utills.Server;
import java.util.Scanner;
public class ShopServer extends Server {
    private List<Bestellung> bestellungen;

    ShopServer(int pPortnummer){
        super(pPortnummer);

    }

    public void processNewConnection(String pClientIP, int pClientPort) {
        this.send(pClientIP, pClientPort, "Willkommen! Wählen Sie eine Größe und eine Farbe für Ihr Einhornfurzkissen.");
    }

    public void processMessage(String pClientIP, int pClientPort, String pMessage) {
        String[] nachrichtTeil = pMessage.split(":");
        if(nachrichtTeil[0].equals("Einhornfurzkissen")) {
           // System.out.println(this.send(pClientIP,pClientPort,"Welche Größe soll es haben?"));
            this.send(pClientIP, pClientPort, "Die Groesse ist" + nachrichtTeil[1] + ", die Farbe ist " + nachrichtTeil[2]+" und es kostet 19,99 Euro! Bitte bestätigen Sie die Bestellung.");
        }else if(nachrichtTeil[0].equals("BESTAETIGUNG")) {
            if(nachrichtTeil[1].equals("ja")) {
                this.send (pClientIP, pClientPort, "Vielen Dank für Ihre Bestellung."); closeConnection(pClientIP, pClientPort);
            } else if (nachrichtTeil[1].equals("nein")) {
                closeConnection(pClientIP, pClientPort);
            } else {
                this.send(pClientIP, pClientPort, "Bitte geben Sie ja oder nein ein.");
            }
        } else if (nachrichtTeil[0].equals("ABMELDEN")) {
            closeConnection(pClientIP, pClientPort);
        }else{
            this.send(pClientIP, pClientPort, "Bitte korri- gieren Sie Ihre Eingabe.");
        }
    }


    @Override
    public void processClosingConnection(String pClientIP, int pClientPort) {

    }

    public void processClosedConnection(String pClient, int pClientPort){

    }
}

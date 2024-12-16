import Utills.Client;
import javax.swing.JOptionPane;

public class ShopClient extends Client{

    ShopClient(String pServerIP, int pServerPort) {
        super(pServerIP, pServerPort);
    }

    public void groesseFarbeWaehlen(String pGroesse, String pFarbe){
        this.send("Einhornfurzkissen: "+ pGroesse+":"+pFarbe);
    }

    public void bestaetigen(String pAntwort){
        this.send ("BESTAETIGUNG:"+ pAntwort);
    }

    public void abmelden() {
        this.send("ABMELDEN");
    }

    public void processMessage(String pMessage) {
        JOptionPane.showMessageDialog(null,"Server sendet:\n" + pMessage);
    }

    public void sendMessageToServer() {
        String lMessage;
        lMessage = JOptionPane.showInputDialog("Bitte geben Sie eine neue Nachricht ein:");
        send(lMessage);
    }


}

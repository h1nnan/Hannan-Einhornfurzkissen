public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //hier passiert noch was!
        ShopServer shopServer = new ShopServer(13);
        ShopClient shopClient = new ShopClient("10.56.17.207", 13);

        shopClient.groesseFarbeWaehlen("XL","Rot");
        shopClient.bestaetigen("ja");
        shopClient.abmelden();

        //shopServer.processNewConnection("10.56.17.205", 7);

    }
}
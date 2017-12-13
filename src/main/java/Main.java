//https://sourceafis.machinezoo.com/

public class Main {

    public static void main(String[] args) throws Exception {

        SocketServer.start("localhost", 3000);
        SocketClient.start("ws://localhost:3000");

//        FingerAuthentication fingerAuthentication = new FingerAuthentication();
//        fingerAuthentication.matching1toN();
//        fingerAuthentication.matching1toN();



    }
}

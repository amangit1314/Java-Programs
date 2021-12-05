//package rmi_2;
import java.rmi.*;
import java.rmi.AlreadyBoundException;
//import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    //private static final int PORT = 5000;
    public static void main(String[] args) {

        try {
            Authentication authentication = new AuthenticationImpl();

            LocateRegistry.createRegistry(5000);

            Naming.rebind("rmi://localhost:5000/AS", authentication);
            //Naming.rebind();

            //System.out.println("Authentication Service running at " + PORT + " port...");

        } catch (Exception e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
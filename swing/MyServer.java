package swing;

//MyServer.java
import java.rmi.*;
import java.rmi.registry.*;

public class MyServer {
    public static void main(String[] args) {
        try {
            AddServer obj = new AddRemote();
            LocateRegistry.createRegistry(5000);
            Naming.rebind("rmi://localhost:5000/AS", obj);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }
}